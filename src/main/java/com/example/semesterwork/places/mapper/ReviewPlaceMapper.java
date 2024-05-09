package com.example.semesterwork.places.mapper;

import com.example.semesterwork.places.dto.ReviewPlaceDto;
import com.example.semesterwork.places.model.ReviewPlaceModel;
import com.example.semesterwork.places.repository.PlaceRepository;
import com.example.semesterwork.places.request.ReviewPlaceRequest;
import com.example.semesterwork.user.mapper.UserMapper;
import com.example.semesterwork.user.repo.UserRepo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReviewPlaceMapper {

    private final PlaceRepository placeRepository;
    private final UserRepo userRepository;
    private final UserMapper userMapper;
    private final PlaceMapper placeMapper;

    public ReviewPlaceDto toDto(ReviewPlaceModel entity) {
        return ReviewPlaceDto.builder()
                .id(entity.getId())
                .text(entity.getText())
                .rating(entity.getRating())
                .place(placeMapper.toDto(entity.getPlace()))
                .user(userMapper.entityToDto(entity.getUser()))
                .build();
    }

//    public ReviewPlaceModel toEntity(ReviewPlaceDto dto) {
//        return ReviewPlaceModel.builder()
//                .id(dto.getId())
//                .text(dto.getText())
//                .rating(dto.getRating())
//                .placeId(dto.getPlace().getId())
//                .userId(entity.getUserId())
//                .build();
//    }

    public ReviewPlaceModel toEntity(ReviewPlaceRequest request) {
        return ReviewPlaceModel.builder()
                .id(-1L)
                .text(request.getText())
                .rating(request.getRating())
                .place(placeRepository.findById(request.getPlaceId()).orElseThrow())
                .build();
    }

}
