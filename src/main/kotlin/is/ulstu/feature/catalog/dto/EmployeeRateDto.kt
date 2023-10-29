package `is`.ulstu.feature.catalog.dto

@kotlinx.serialization.Serializable
data class EmployeeRateDto(
    val teamWork: RatedValueDto?,
    val leadership: RatedValueDto?,
    val responsibility: RatedValueDto?,
    val employeesRate: RatedValueDto?,
    val clientsRate: RatedValueDto?,
    val bossRate: RatedValueDto?,
    val organizationWorkProcess: RatedValueDto?,
    val punctuality: RatedValueDto?,
    val stressResistance: RatedValueDto?,
    val creativity: RatedValueDto?,
    val analyticsSkills: RatedValueDto?,
    val communicationsSkills: RatedValueDto?,
)
