package com.example.semesterwork.places.service;

import com.example.semesterwork.places.dto.ReviewPlaceDto;
import com.example.semesterwork.places.mapper.ReviewPlaceMapper;
import com.example.semesterwork.places.repository.ReviewPlaceRepository;
import com.example.semesterwork.places.request.ReviewPlaceRequest;
import com.example.semesterwork.token.TokenRepo;
import lombok.AllArgsConstructor;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewPlaceService {

    private static final Logger log = LoggerFactory.getLogger(ReviewPlaceService.class);
    private final ReviewPlaceRepository repository;
    private final ReviewPlaceMapper mapper;
    private final TokenRepo tokenRepo;

    public ReviewPlaceDto createPlaceReview(ReviewPlaceRequest reviewPlaceRequest, String token) {
        log.info(token);
        val user = tokenRepo.findByToken(token.split(" ")[1]).orElseThrow().getUser();
        val entity = mapper.toEntity(reviewPlaceRequest);
        entity.setUser(user);
        return mapper.toDto(repository.save(entity));
    }

    public List<ReviewPlaceDto> getAllReviews(Long placeId) {
        return repository.findReviewPlaceModelByPlaceId(placeId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
