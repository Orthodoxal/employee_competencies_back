package `is`.ulstu.plugins

import `is`.ulstu.feature.authorization.AuthorizationController
import `is`.ulstu.feature.authorization.AuthorizationRepository
import `is`.ulstu.feature.authorization.AuthorizationRepositoryImpl
import `is`.ulstu.feature.catalog.CatalogController
import `is`.ulstu.feature.catalog.CatalogRepository
import `is`.ulstu.feature.catalog.CatalogRepositoryImpl

object Store {
    val authorizationRepository: AuthorizationRepository by lazy { AuthorizationRepositoryImpl() }
    val authorizationController: AuthorizationController by lazy { AuthorizationController() }

    val catalogRepository: CatalogRepository by lazy { CatalogRepositoryImpl() }
    val catalogController: CatalogController by lazy { CatalogController() }
}