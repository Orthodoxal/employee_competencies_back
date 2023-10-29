package `is`.ulstu

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import `is`.ulstu.feature.authorization.configureAuthRouting
import `is`.ulstu.feature.catalog.configureCatalogRouting
import `is`.ulstu.plugins.configureRouting
import `is`.ulstu.plugins.configureSerialization

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureAuthRouting()
    configureSerialization()
    configureCatalogRouting()
}
