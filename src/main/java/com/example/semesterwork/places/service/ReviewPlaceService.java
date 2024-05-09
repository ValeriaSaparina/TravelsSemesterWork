package com.example.semesterwork.places.service;

import com.example.semesterwork.places.mapper.ReviewPlaceMapper;
import com.example.semesterwork.places.repository.ReviewPlaceRepository;
import com.example.semesterwork.places.request.ReviewPlaceRequest;
import com.example.semesterwork.token.TokenRepo;
import com.example.semesterwork.user.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewPlaceService {

    private static final Logger log = LoggerFactory.getLogger(ReviewPlaceService.class);
    private final ReviewPlaceRepository repository;
    private final ReviewPlaceMapper mapper;
    private final UserRepo userRepo;
    private final TokenRepo tokenRepo;

    public void createPlaceReview(ReviewPlaceRequest reviewPlaceRequest, String token) {
        log.info(token);
        val user = tokenRepo.findByToken(token.split(" ")[1]).orElseThrow().getUser();
        val entity = mapper.toEntity(reviewPlaceRequest);
        entity.setUser(user);
        repository.save(entity);
    }
}
