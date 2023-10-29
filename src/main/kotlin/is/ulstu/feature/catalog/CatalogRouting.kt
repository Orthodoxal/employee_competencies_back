package `is`.ulstu.feature.catalog

import io.ktor.server.application.*
import io.ktor.server.routing.*
import `is`.ulstu.plugins.Store

fun Application.configureCatalogRouting() {
    routing {
        get("/catalog") {
            Store.catalogController.apply { loadCatalog(call) }
        }
    }
}