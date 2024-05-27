package com.example.semesterwork.places;


import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.places.dto.ReviewPlaceDto;
import com.example.semesterwork.places.model.ReviewPlaceModel;
import com.example.semesterwork.places.request.ReviewPlaceRequest;
import com.example.semesterwork.places.service.PlaceService;
import com.example.semesterwork.places.service.ReviewPlaceService;
import com.example.semesterwork.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/places")
public class PlacesController {

    private final PlaceService placeService;
    private final ReviewPlaceService reviewPlaceService;

    @GetMapping("/allPlaces")
    public ResponseEntity<List<PlaceDto>> getAllPlaces() {
        return ResponseEntity.ok(placeService.findAll());
    }

    @RequestMapping(value = "placeDetails", method = RequestMethod.GET)
    public ResponseEntity<PlaceDto> getPlaceById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(placeService.findById(id));
    }

    @RequestMapping(value = "places", method = RequestMethod.GET)
    public ResponseEntity<List<PlaceDto>> getPlaceByQuery(
            @RequestParam("query") String query,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("pageNumber") Integer pageNumber
    ) {
        return ResponseEntity.ok(placeService.findByQuery(query, pageNumber - 1, pageSize));
    }

    @RequestMapping(value = "sendReview", method = RequestMethod.POST)
    public ResponseEntity<ReviewPlaceDto> createPlaceReview(@RequestBody ReviewPlaceRequest reviewPlaceRequest,
                                                            @RequestHeader("Authorization") String token) {
        HttpStatus status;
        ReviewPlaceDto responseBody = null;
        try {
            responseBody = reviewPlaceService.createPlaceReview(reviewPlaceRequest, token);
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(responseBody);
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<ReviewPlaceDto>> getAllReviews(@RequestParam("placeId") Long placeId) {
        HttpStatus status;
        List<ReviewPlaceDto> responseBody = null;
        try {
            responseBody = reviewPlaceService.getAllReviews(placeId);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(responseBody);
    }

    @RequestMapping(value = "/addFavPlace", method = RequestMethod.POST)
    public ResponseEntity<GeneralResponse> addFavRoute(@RequestBody Long placeId,
                                                       @RequestHeader("Authorization") String token) {
        HttpStatus status;
        try {
            placeService.addFavPlace(placeId, token);
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        GeneralResponse responseBody = GeneralResponse.builder()
                .code(status.value())
                .message(status.getReasonPhrase())
                .build();
        return ResponseEntity.status(status).body(responseBody);
    }

    // TODO: findByType;

}
