package `is`.ulstu.feature.authorization.dto

import `is`.ulstu.base.ResponseStatus

@kotlinx.serialization.Serializable
data class RemoveActiveUserResponseDto(
    val status: ResponseStatus
)
