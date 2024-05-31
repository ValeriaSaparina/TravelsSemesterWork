package com.example.travels.domain.routes.usercase

//
//class GetRouteByIdUseCase @Inject constructor(
//    private val repository: RoutesRepository,
//    private val mapper: RouteDomainMapper,
//) {
//    suspend operator fun invoke(id: String): Result<RouteDomainModel> {
//        return runSuspendCatching {
//            mapper.toDomainModel(repository.getRoute(id)!!)
//        }
//    }
//}