package `is`.ulstu.feature.authorization

import `is`.ulstu.feature.authorization.dto.UserDto

interface AuthorizationRepository {
    fun getAllUsers(): List<UserDto>
    fun getUserById(id: Long): UserDto?
    fun addActiveUser(userDto: UserDto): String
    fun removeActiveUser(token: String)
    fun getActiveUserIdByToken(token: String): Long?
}