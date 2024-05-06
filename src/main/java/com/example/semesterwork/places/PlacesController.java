package com.example.semesterwork.places;


import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.places.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/places")
public class PlacesController {

    private final PlaceService placeService;

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
        return ResponseEntity.ok(placeService.findByQuery(query, pageNumber, pageSize));
    }

    // TODO: findByType;

}
