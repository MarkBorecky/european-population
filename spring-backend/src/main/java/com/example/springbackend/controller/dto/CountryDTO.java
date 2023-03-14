package com.example.springbackend.controller.dto;

import com.example.springbackend.repository.entity.Country;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CountryDTO(
        String countryCode,
        String country,
        String flagEmoji,
        Integer population) {


    public static CountryDTO map(Country country) {
        return new CountryDTO(
                country.getCode(),
                country.getName(),
                country.getFlag(),
                country.getPopulation()
        );
    }
}
