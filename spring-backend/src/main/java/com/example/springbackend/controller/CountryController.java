package com.example.springbackend.controller;

import com.example.springbackend.controller.dto.CountryDTO;
import com.example.springbackend.controller.filter.CountryFilter;
import com.example.springbackend.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/api/v1/countries")
    @Operation(
            summary = "Gets all countries",
            parameters = {
                    @Parameter(name = "code", description = "part of code for searching query"),
                    @Parameter(name = "countryName", description = "part of country name for searching query"),
                    @Parameter(name = "populationLowerThan", description = "Received countries will have smaller population than passed parameter"),
                    @Parameter(name = "populationGreaterThan", description = "Received countries will have greater population than passed parameter")
            })
    List<CountryDTO> fetchAll(CountryFilter filter) {
        return countryService.findAll(filter);
    }
}
