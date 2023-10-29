package `is`.ulstu.feature.authorization

import io.ktor.server.application.*
import io.ktor.server.routing.*
import `is`.ulstu.plugins.Store

fun Application.configureAuthRouting() {
    routing {
        post("/auth") {
            Store.authorizationController.apply { authUser(call) }
        }

        post("/authByToken") {
            Store.authorizationController.apply { authUserByToken(call) }
        }

        post("/logout") {
            Store.authorizationController.apply { logoutActiveUserByToken(call) }
        }
    }
}