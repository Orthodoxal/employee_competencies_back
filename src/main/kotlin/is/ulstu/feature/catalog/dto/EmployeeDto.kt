package `is`.ulstu.feature.catalog.dto

@kotlinx.serialization.Serializable
data class EmployeeDto(
    val fullName: String,
    val city: String,
    val birthDate: String,
    val department: String,
    val position: String,
    val seniority: String,
    val hardSkills: List<String>,
    val softSkills: List<String>,
    val techs: List<String>,
    val hrRecommendations: List<String>,
    val achievements: List<String>,
    val salary: String,
    val rate: EmployeeRateDto,
)
