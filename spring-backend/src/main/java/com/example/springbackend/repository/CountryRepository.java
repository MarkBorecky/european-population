package com.example.springbackend.repository;

import com.example.springbackend.controller.filter.CountryFilter;
import com.example.springbackend.repository.entity.Country;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country> {

    static Specification<Country> countryCodeContain(String code) {
        return (country, cq, cb) -> cb.like(cb.lower(country.get("code")), StringUtils.wrap(code.toLowerCase(), "%"));
    }

    static Specification<Country> countryNameContain(String name) {
        return (country, cq, cb) -> cb.like(cb.lower(country.get("name")), StringUtils.wrap(name.toLowerCase(), "%"));
    }

    static Specification<Country> countryPopulationGraterThan(Integer population) {
        return (country, cq, cb) -> cb.gt(country.get("population"), population);
    }

    static Specification<Country> countryPopulationLowerThan(Integer population) {
        return (country, cq, cb) -> cb.lt(country.get("population"), population);
    }

    default List<Country> findByFilter(CountryFilter filter) {
        List<Specification<Country>> countrySpecifications = Stream.of(
                        filter.optionalCode().map(CountryRepository::countryCodeContain),
                        filter.optionalName().map(CountryRepository::countryNameContain),
                        filter.optionalPopulationLowerThan().map(CountryRepository::countryPopulationLowerThan),
                        filter.optionalPopulationGreaterThan().map(CountryRepository::countryPopulationGraterThan))
                .flatMap(Optional::stream)
                .toList();
        return findAll(Specification.allOf(countrySpecifications));
    }
}
