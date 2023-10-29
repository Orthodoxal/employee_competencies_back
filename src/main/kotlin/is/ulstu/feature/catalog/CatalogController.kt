package `is`.ulstu.feature.catalog

import io.ktor.server.application.*
import io.ktor.server.response.*
import `is`.ulstu.plugins.Store

class CatalogController {
    private val catalogRepository = Store.catalogRepository

    suspend fun loadCatalog(call: ApplicationCall) {
        val catalog = catalogRepository.loadEmployeesCatalog()
        call.respond(catalog)
    }
}