package `is`.ulstu.plugins

import `is`.ulstu.feature.authorization.AuthorizationController
import `is`.ulstu.feature.authorization.AuthorizationRepository
import `is`.ulstu.feature.authorization.AuthorizationRepositoryImpl

object Store {
    val authorizationRepository: AuthorizationRepository by lazy { AuthorizationRepositoryImpl() }
    val authorizationController: AuthorizationController by lazy { AuthorizationController() }
}