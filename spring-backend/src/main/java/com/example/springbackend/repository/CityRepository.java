package com.example.springbackend.repository;

import com.example.springbackend.controller.filter.CityFilter;
import com.example.springbackend.repository.entity.City;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    private static Specification<City> cityNameContains(@NonNull String cityName) {
        return (city, cq, cb) -> cb.like(
                cb.lower(city.get("name")),
                StringUtils.wrap(cityName.toLowerCase(), "%"));
    }

    private static Specification<City> countryNameContains(@NonNull String countryName) {
        return (city, cq, cb) -> cb.like(
                cb.lower(city.get("country").get("name")),
                StringUtils.wrap(countryName.toLowerCase(), "%"));
    }

    private static Specification<City> populationGreaterThan(@NonNull Integer populationSize) {
        return (city, cq, cb) -> cb.gt(
                city.get("population"),
                populationSize);
    }

    private static Specification<City> populationLowerThan(@NonNull Integer populationSize) {
        return (city, cq, cb) -> cb.lt(
                city.get("population"),
                populationSize);
    }

    default List<City> findByFilter(CityFilter filter) {
        List<Specification<City>> citySpecifications = Stream.of(
                        filter.optionalCityName().map(CityRepository::cityNameContains),
                        filter.optionalCountryName().map(CityRepository::countryNameContains),
                        filter.optionalPopulationGreaterThan().map(CityRepository::populationGreaterThan),
                        filter.optionalPopulationLowerThan().map(CityRepository::populationLowerThan))
                .flatMap(Optional::stream)
                .toList();
        return findAll(Specification.allOf(citySpecifications));
    }


}
