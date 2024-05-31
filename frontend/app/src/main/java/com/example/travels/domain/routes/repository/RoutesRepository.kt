package com.example.travels.domain.routes.repository

import com.example.travels.data.routes.remote.model.RouteDataModel
import com.example.travels.data.routes.remote.model.RouteRequestModel
import com.example.travels.domain.routes.model.RouteDomainModel

interface RoutesRepository {
    suspend fun createRoute(route: RouteDomainModel)
    suspend fun searchRoutes(query: String): List<RouteDomainModel>
    suspend fun getRoute(id: String): RouteDataModel?
    suspend fun addNewFavRoute(route: RouteDomainModel)
    suspend fun deleteFavRoute(id: String)
    suspend fun getAllFavRoutes(): List<RouteDomainModel>
    suspend fun getFavRouteById(id: String): RouteDomainModel
    suspend fun deleteAllFavRoutes()
    suspend fun getIdAllFavRoutes(): List<String>
    suspend fun getFavRoutes(n: Int): List<RouteDomainModel>
}
