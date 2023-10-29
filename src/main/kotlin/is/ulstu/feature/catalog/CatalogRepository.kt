package `is`.ulstu.feature.catalog

import `is`.ulstu.feature.catalog.dto.EmployeeDto

interface CatalogRepository {
    fun loadEmployeesCatalog(): List<EmployeeDto>
}