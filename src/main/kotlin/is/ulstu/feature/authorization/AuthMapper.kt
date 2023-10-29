package `is`.ulstu.feature.authorization

import `is`.ulstu.feature.authorization.dto.AuthUserResponseDto
import `is`.ulstu.feature.authorization.dto.UserDto

fun UserDto.mapToAuthUserResponseDto(token: String) = AuthUserResponseDto(
    fullName = fullName,
    department = department,
    position = position,
    city = city,
    token = token,
)