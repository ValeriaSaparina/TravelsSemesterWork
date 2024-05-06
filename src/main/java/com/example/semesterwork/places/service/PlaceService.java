package com.example.semesterwork.places.service;

import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.places.mapper.PlaceMapper;
import com.example.semesterwork.places.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;
    private final PlaceMapper mapper;

    public PlaceDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public List<PlaceDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<PlaceDto> findByQuery(String query, Integer pageNumber, Integer pageSize) {
        return repository.findByQuery(query, PageRequest.of(pageNumber, pageSize)).orElseThrow()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
