package com.example.springbackend.controller.filter;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import java.util.Optional;

public record CountryFilter(
        @Nullable
        String code,
        @Nullable
        String name,
        @Nullable
        @Positive
        Integer populationLowerThan,
        @Nullable
        @Positive
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
