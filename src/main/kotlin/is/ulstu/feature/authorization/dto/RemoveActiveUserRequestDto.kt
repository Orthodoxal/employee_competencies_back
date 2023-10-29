package `is`.ulstu.feature.authorization.dto

@kotlinx.serialization.Serializable
data class RemoveActiveUserRequestDto(
    val token: String
)
