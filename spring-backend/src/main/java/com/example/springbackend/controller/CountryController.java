package com.example.springbackend.controller;

import com.example.springbackend.controller.dto.CountryDTO;
import com.example.springbackend.controller.filter.CountryFilter;
import com.example.springbackend.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Countries")
@Validated
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/api/v1/countries")
    @Operation(summary = "Gets all countries")
    List<CountryDTO> fetchAll(@Valid @RequestBody CountryFilter filter) {
        return countryService.findByFilter(filter);
    }
}
