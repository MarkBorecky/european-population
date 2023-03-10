package com.example.springbackend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/api/v1/countries")
    List<Country> fetchAll() {
        return List.of(
                new Country("Poland"),
                new Country("Finland"),
                new Country("Sweden")
        );
    }
}
