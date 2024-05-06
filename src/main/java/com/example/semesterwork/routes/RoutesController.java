package com.example.semesterwork.routes;


import com.example.semesterwork.places.dto.PlaceDto;
import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/routes")
public class RoutesController {

    private final RouteService routeService;

    @GetMapping("/allRoutes")
    public ResponseEntity<List<RouteDto>> getAllPlaces() {
        return ResponseEntity.ok(routeService.findAll());
    }

    @RequestMapping(value = "/routeDetails", method = RequestMethod.GET)
    public ResponseEntity<RouteDto> getPlaceById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(routeService.findById(id));
    }

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ResponseEntity<List<RouteDto>> getPlaceByQuery(
            @RequestParam("query") String query,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("pageNumber") Integer pageNumber
    ) {
        return ResponseEntity.ok(routeService.findByQuery(query, pageNumber, pageSize));
    }

    // TODO: findByType;

}
