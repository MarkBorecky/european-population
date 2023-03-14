package com.example.springbackend.controller.filter;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import java.util.Optional;

public record CityFilter(
        @Nullable
        String cityName,
        @Nullable
        String countryName,
        @Nullable
        @Positive
        Integer populationLowerThan,
        @Nullable
        @Positive
        Integer populationGreaterThan,
        @Nullable
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
