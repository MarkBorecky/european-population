package com.example.springbackend.controller.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import java.util.Optional;

public record CityFilter(
        @Nullable
        @Schema(name = "cityName", description = "part of city name for searching query", example = "Helsinki")
        String cityName,
        @Nullable
        @Schema(name = "countryName", description = "part of country name for searching query", example = "Finland")
        String countryName,
        @Nullable
        @Positive
        @Schema(name = "populationLowerThan", description = "Received cities will have smaller population than passed parameter", example = "1000000000")
        Integer populationLowerThan,
        @Nullable
        @Positive
        @Schema(name = "populationGreaterThan", description = "Received cities will have greater population than passed parameter", example = "1")
        Integer populationGreaterThan,
        @Nullable
        @Schema(name = "isCapital", description = "Parameter describe if method have to cities which are capitals or not")
        Boolean isCapital
) {

    public Optional<String> optionalCityName() {
        return Optional.ofNullable(cityName);
    }

    public Optional<String> optionalCountryName() {
        return Optional.ofNullable(countryName);
    }

    public Optional<Integer> optionalPopulationLowerThan() {
        return Optional.ofNullable(populationLowerThan);
    }

    public Optional<Integer> optionalPopulationGreaterThan() {
        return Optional.ofNullable(populationGreaterThan);
    }

    public Optional<Boolean> optionalIsCapital() {
        return Optional.ofNullable(isCapital);
    }

}
