package com.example.springbackend.controller.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import java.util.Optional;

public record CountryFilter(
        @Nullable
        @Schema(name = "code", description = "part of code for searching query", example = "FIN")
        String code,
        @Nullable
        @Schema(name = "countryName", description = "part of country name for searching query", example = "Finland")
        String name,
        @Nullable
        @Positive
        @Schema(name = "populationLowerThan", description = "Received countries will have smaller population than passed parameter", example = "1000000000")
        Integer populationLowerThan,
        @Nullable
        @Positive
        @Schema(name = "populationGreaterThan", description = "Received countries will have greater population than passed parameter", example = "1")
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
