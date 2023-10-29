package `is`.ulstu.feature.authorization

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import `is`.ulstu.feature.authorization.dto.AuthUserByTokenRequestDto
import `is`.ulstu.feature.authorization.dto.AuthUserRequestDto
import `is`.ulstu.feature.authorization.dto.RemoveActiveUserRequestDto
import `is`.ulstu.base.ErrorResponseBody
import `is`.ulstu.base.ResponseStatus
import `is`.ulstu.feature.authorization.dto.RemoveActiveUserResponseDto
import `is`.ulstu.plugins.Store

class AuthorizationController {
    private val authRepository = Store.authorizationRepository

    suspend fun authUser(call: ApplicationCall) {
        val authUserRequestDto = call.receive<AuthUserRequestDto>()
        val userDto = authRepository.getAllUsers()
            .find { userDto ->
                userDto.login == authUserRequestDto.login && userDto.password == authUserRequestDto.password
            }
        if (userDto == null) {
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponseBody("Пользователя с таким логином или паролем не существует")
            )
        } else {
            val token = authRepository.addActiveUser(userDto)
            val authUserResponseDto = userDto.mapToAuthUserResponseDto(token = token)
            call.respond(authUserResponseDto)
        }
    }

    suspend fun authUserByToken(call: ApplicationCall) {
        val authUserByTokenRequestDto = call.receive<AuthUserByTokenRequestDto>()
        val userId = authRepository.getActiveUserIdByToken(authUserByTokenRequestDto.token)
        if (userId == null) {
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponseBody("Токен авторизации просрочен, войдите заново")
            )
        } else {
            val user = authRepository.getUserById(userId)
            if (user == null) {
                call.respond(
                    HttpStatusCode.NotFound,
                    ErrorResponseBody("Пользователь не найден или был удален")
                )
            } else {
                val authUserResponseDto = user.mapToAuthUserResponseDto(token = authUserByTokenRequestDto.token)
                call.respond(authUserResponseDto)
            }
        }
    }

    suspend fun logoutActiveUserByToken(call: ApplicationCall) {
        val removeActiveUserRequestDto = call.receive<RemoveActiveUserRequestDto>()
        authRepository.removeActiveUser(removeActiveUserRequestDto.token)
        val removeActiveUserResponseDto = RemoveActiveUserResponseDto(status = ResponseStatus.SUCCESS)
        call.respond(removeActiveUserResponseDto)
    }

}