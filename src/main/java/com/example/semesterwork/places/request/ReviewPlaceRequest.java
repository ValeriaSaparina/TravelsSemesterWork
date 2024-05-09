package com.example.semesterwork.places.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPlaceRequest {
    private String text;
    private Float rating;
    private Long placeId;
}
