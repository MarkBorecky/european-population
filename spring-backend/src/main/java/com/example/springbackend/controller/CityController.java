package com.example.springbackend.controller;

import com.example.springbackend.model.City;
import com.example.springbackend.model.CityWithCountry;
import com.example.springbackend.service.CityService;
import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/api/v1/cities")
    List<City> findBy(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String countryCode,
            @RequestParam(required = false) @Positive Integer populationGreaterThan,
            @RequestParam(required = false) @Positive Integer populationLowerThan) {
        return cityService.findByCriteria(name, countryCode, populationLowerThan, populationGreaterThan);
    }

    @GetMapping("/api/v1/cities-by-size/{minimalPopulation}")
    List<CityWithCountry> findByCitiesSize(@Positive @PathVariable Integer minimalPopulation) {
        return cityService.findWithCitiesPopulationGreaterThan(minimalPopulation);
    }
}
