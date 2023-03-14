package com.example.springbackend.controller.dto;

import com.example.springbackend.repository.entity.City;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CityDTO(String country, String city, Integer population, Boolean isCapital) {

    public static CityDTO map(City city) {
        return new CityDTO(
                city.getCountry().getName(),
                city.getName(),
                city.getPopulation(),
                city.getCapital()
        );
    }
}
