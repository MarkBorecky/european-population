package com.example.springbackend.controller.dto;

import com.example.springbackend.repository.entity.Country;

public record CountryDTO(
        String countryCode,
        String countryName,
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
