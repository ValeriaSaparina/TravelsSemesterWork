package com.example.semesterwork.routes;


import com.example.semesterwork.routes.dto.RouteDto;
import com.example.semesterwork.routes.model.RouteRequest;
import com.example.semesterwork.routes.service.RouteService;
import com.example.semesterwork.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
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

    @RequestMapping(value = "/routesWithPage", method = RequestMethod.GET)
    public ResponseEntity<List<RouteDto>> getPlaceByQueryPage(
            @RequestParam("query") String query,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("pageNumber") Integer pageNumber
    ) {
        return ResponseEntity.ok(routeService.findByQuery(query, pageNumber, pageSize));
    }


    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ResponseEntity<List<RouteDto>> getPlaceByQuery(
            @RequestParam("query") String query
    ) {
        return ResponseEntity.ok(routeService.findByQuery(query));
    }


    @RequestMapping(value = "/addFavRoute", method = RequestMethod.POST)
    public ResponseEntity<GeneralResponse> addFavRoute(@RequestBody Long routeId,
                                                       @RequestHeader("Authorization") String token) {
        HttpStatus status;
        try {
            routeService.addFavRoute(routeId, token);
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            log.error(e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        GeneralResponse responseBody = GeneralResponse.builder()
                .code(status.value())
                .message(status.getReasonPhrase())
                .build();
        return ResponseEntity.status(status).body(responseBody);
    }

    @PostMapping("/createRoute")
    public ResponseEntity<GeneralResponse> createRoute(@RequestBody RouteRequest routeRequest) {
        HttpStatus status;
        try {
            routeService.createRoute(routeRequest);
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            log.error(e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        GeneralResponse responseBody = GeneralResponse.builder()
                .code(status.value())
                .message(status.getReasonPhrase())
                .build();
        return ResponseEntity.status(status).body(responseBody);
    }

}

