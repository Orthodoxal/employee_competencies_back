package `is`.ulstu.feature.catalog

import `is`.ulstu.feature.catalog.dto.EmployeeDto
import kotlinx.serialization.json.Json

private const val CATALOG_FILE_PATH = "catalog.json"

class CatalogRepositoryImpl : CatalogRepository {
    override fun loadEmployeesCatalog(): List<EmployeeDto> {
        val jsonContent = this::class.java.classLoader.getResource(CATALOG_FILE_PATH)?.readText()
        val catalog = jsonContent?.let { Json.decodeFromString<List<EmployeeDto>>(it) }
        return catalog ?: emptyList()
    }
}