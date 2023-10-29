package `is`.ulstu.feature.authorization.dto

@kotlinx.serialization.Serializable
data class AuthUserRequestDto(
    val login: String,
    val password: String,
)