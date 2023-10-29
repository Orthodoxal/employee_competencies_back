package `is`.ulstu.feature.authorization.dto

@kotlinx.serialization.Serializable
data class AuthUserByTokenRequestDto(
    val token: String
)
