package `is`.ulstu.feature.authorization.dto

@kotlinx.serialization.Serializable
data class AuthUserResponseDto(
    val fullName: String,
    val department: String,
    val position: String,
    val city: String,
    val token: String,
)