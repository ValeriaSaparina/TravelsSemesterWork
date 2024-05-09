package com.example.semesterwork.routes.service;

import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.mapper.RouteMapper;
import com.example.semesterwork.routes.model.RouteRequest;
import com.example.semesterwork.routes.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private static final Logger log = LoggerFactory.getLogger(RouteService.class);
    private final RouteRepository repository;
    private final RouteMapper mapper;

    public RouteDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public List<RouteDto> findAll() {
        log.info(String.valueOf(repository.findAll()));
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<RouteDto> findByQuery(String query, Integer pageNumber, Integer pageSize) {
        return repository.findByQuery(query, PageRequest.of(pageNumber, pageSize)).orElseThrow()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void createRoute(RouteRequest routeRequest) {
        repository.save(mapper.toEntity(routeRequest));
    }

    public void addFavRoute(Long routeId) {
//        repository.
    }

    public List<RouteDto> findByQuery(String query) {
        return repository.findByQuery(query).orElseThrow().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
