package `is`.ulstu.feature.catalog

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import `is`.ulstu.base.ErrorResponseBody
import `is`.ulstu.plugins.Store

class CatalogController {
    private val catalogRepository = Store.catalogRepository
    private val authorizationRepository = Store.authorizationRepository

    suspend fun loadCatalog(call: ApplicationCall) {
        val token = call.request.headers["Authorization"]
        if (token == null) {
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponseBody("Неверный Header")
            )
            return
        }
        if (authorizationRepository.getActiveUserIdByToken(token) == null) {
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponseBody("Токен авторизации просрочен, войдите заново")
            )
        } else {
            val catalog = catalogRepository.loadEmployeesCatalog()
            call.respond(catalog)
        }
    }
}