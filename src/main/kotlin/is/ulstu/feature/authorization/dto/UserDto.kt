package `is`.ulstu.feature.authorization.dto

@kotlinx.serialization.Serializable
data class UserDto(
    val id: Long,
    val fullName: String,
    val department: String,
    val position: String,
    val city: String,
    val login: String,
    val password: String,
)
