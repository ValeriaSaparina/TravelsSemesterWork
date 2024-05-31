package com.example.semesterwork.routes.service;

import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.mapper.RouteMapper;
import com.example.semesterwork.routes.model.FavoriteRouteModel;
import com.example.semesterwork.routes.model.RouteRequest;
import com.example.semesterwork.routes.repository.FavoriteRoutesRepository;
import com.example.semesterwork.routes.repository.RouteRepository;
import com.example.semesterwork.token.TokenRepo;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repository;
    private final TokenRepo tokenRepo;
    private final FavoriteRoutesRepository favoriteRepository;
    private final RouteMapper mapper;

    public RouteDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public List<RouteDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<RouteDto> findByQuery(String query, Integer pageNumber, Integer pageSize) {
        return repository.findByQuery(query, PageRequest.of(pageNumber, pageSize)).orElseThrow()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void createRoute(RouteRequest routeRequest) {
        repository.save(mapper.toEntity(routeRequest));
    }

    public void addFavRoute(Long routeId, String token) {
        val user = tokenRepo.findByToken(token.split(" ")[1]).orElseThrow().getUser();
        favoriteRepository.save(FavoriteRouteModel.builder()
                .route(repository.getReferenceById(routeId))
                .userId(user.getId())
                .build());
    }

    public List<RouteDto> findByQuery(String query) {
        return repository.findByQuery(query).orElseThrow().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
