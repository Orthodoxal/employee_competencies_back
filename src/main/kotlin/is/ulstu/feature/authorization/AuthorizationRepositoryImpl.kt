package `is`.ulstu.feature.authorization

import `is`.ulstu.feature.authorization.dto.UserDto
import kotlinx.serialization.json.Json
import java.util.UUID

private const val USERS_FILE_PATH = "users.json"

class AuthorizationRepositoryImpl : AuthorizationRepository {
    private val activeUserTokens: MutableMap<String, Long> = mutableMapOf()

    override fun getAllUsers(): List<UserDto> {
        val jsonContent = this::class.java.classLoader.getResource(USERS_FILE_PATH)?.readText()
        val users = jsonContent?.let { Json.decodeFromString<List<UserDto>>(it) }
        return users ?: emptyList()
    }

    override fun getUserById(id: Long): UserDto? = getAllUsers().find { it.id == id }

    override fun addActiveUser(userDto: UserDto): String {
        val token = UUID.randomUUID().toString()
        activeUserTokens[token] = userDto.id
        return token
    }

    override fun removeActiveUser(token: String) {
        activeUserTokens.remove(token)
    }

    override fun getActiveUserIdByToken(token: String): Long? = activeUserTokens[token]
}