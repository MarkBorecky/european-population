package com.example.springbackend.controller.filter;

import java.util.Optional;

public record CountryFilter(
        String code,
        String name,
        Integer populationLowerThan,
        Integer populationGreaterThan
) {

    public Optional<String> optionalCode() {
        return Optional.ofNullable(code);
    }

    public Optional<String> optionalName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> optionalPopulationLowerThan() {
        return Optional.ofNullable(populationLowerThan);
    }

    public Optional<Integer> optionalPopulationGreaterThan() {
        return Optional.ofNullable(populationGreaterThan);
    }
}
