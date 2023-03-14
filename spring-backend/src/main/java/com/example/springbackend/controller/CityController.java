package com.example.springbackend.controller;

import com.example.springbackend.controller.dto.CityDTO;
import com.example.springbackend.controller.filter.CityFilter;
import com.example.springbackend.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Cities")
@Validated
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(path = "/api/v1/cities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Query city by criteria",
            parameters = {
                    @Parameter(name = "cityName", description = "part of city name for searching query"),
                    @Parameter(name = "countryName", description = "part of country name for searching query"),
                    @Parameter(name = "populationLowerThan", description = "Received cities will have smaller population than passed parameter"),
                    @Parameter(name = "populationGreaterThan", description = "Received cities will have greater population than passed parameter"),
                    @Parameter(name = "isCapital", description = "Parameter describe if method have to cities which are capitals or not")
            }
    )
    List<CityDTO> findBy(@Valid @RequestBody CityFilter filter) {
        return cityService.findByFilter(filter);
    }
}
