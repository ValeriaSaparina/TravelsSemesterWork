package com.example.semesterwork.routes.service;

import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.places.mapper.PlaceMapper;
import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.mapper.RouteMapper;
import com.example.semesterwork.routes.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repository;
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
}
