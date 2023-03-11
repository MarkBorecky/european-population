package com.example.springbackend.controller;

import com.example.springbackend.model.Country;
import com.example.springbackend.repository.CountryRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/api/v1/countries")
    List<Country> fetchAll() {
        return countryRepository.findAll();
    }
}
