package com.example.travels.data.routes.repository

import com.example.travels.data.routes.remote.mapper.RouteDomainMapper
import com.example.travels.data.routes.remote.model.RouteDataModel
import com.example.travels.data.routes.remote.RoutesApi
import com.example.travels.data.routes.remote.model.RouteRequestModel
import com.example.travels.domain.routes.model.RouteDomainModel
import com.example.travels.domain.routes.repository.RoutesRepository
import javax.inject.Inject

class RoutesRepositoryImpl @Inject constructor(
    private val routesApi: RoutesApi,
    private val mapper: RouteDomainMapper,
) : RoutesRepository {
    override suspend fun createRoute(route: RouteDomainModel) {
        routesApi.createRoute(mapper.toRequest(route))
    }

    override suspend fun searchRoutes(query: String): List<RouteDomainModel> {
        return mapper.toDomainModel(routesApi.getRouteByTextQuery(query))
    }


    override suspend fun getRoute(id: String): RouteDataModel {
        TODO()
    }

    override suspend fun addNewFavRoute(route: RouteDomainModel) {
        TODO()
    }

    override suspend fun deleteFavRoute(id: String) {
        TODO()
    }

    override suspend fun getAllFavRoutes(): List<RouteDomainModel> {
        TODO()
    }

    override suspend fun getFavRouteById(id: String): RouteDomainModel {
        TODO()
    }

    override suspend fun deleteAllFavRoutes() {
        TODO()
    }

    override suspend fun getIdAllFavRoutes(): List<String> {
        TODO()
    }

    override suspend fun getFavRoutes(n: Int): List<RouteDomainModel> {
        TODO()
    }


    companion object {
        private const val ROUTES_COLLECTION_PATH = "routes"
    }

}
