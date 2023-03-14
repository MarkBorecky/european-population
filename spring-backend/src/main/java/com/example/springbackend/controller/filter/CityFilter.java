package com.example.springbackend.controller.filter;

import java.util.Optional;

public record CityFilter(
        String cityName,
        String countryName,
        Integer populationLowerThan,
        Integer populationGreaterThan
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

}
