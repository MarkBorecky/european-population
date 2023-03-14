package com.example.springbackend.controller;

import com.example.springbackend.controller.dto.CityDTO;
import com.example.springbackend.controller.filter.CityFilter;
import com.example.springbackend.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Query city by criteria")
    List<CityDTO> findBy(@Valid @RequestBody CityFilter filter) {
        return cityService.findByFilter(filter);
    }
}
