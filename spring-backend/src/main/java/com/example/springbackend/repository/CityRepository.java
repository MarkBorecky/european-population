package com.example.springbackend.repository;

import com.example.springbackend.model.City;
import com.example.springbackend.model.CityWithCountry;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    @Query(value = "SELECT new com.example.springbackend.model.CityWithCountry(co.name, c.name) " +
            "FROM Country co LEFT JOIN City c " +
            "ON co.code = c.countryCode " +
            "WHERE c.population > :minimalPopulation")
    List<CityWithCountry> findWithCitiesPopulationGreaterThan(@Param("minimalPopulation") Integer minimalPopulation);

    static Specification<City> cityNameContains(String cityName) {
        return (city, cq, cb) -> cb.like(cb.lower(city.get("name")), "%" + cityName.toLowerCase() + "%"); // I could use String interpolation, but this is much more readable than "%%s%.formatted(cityName)"
    }

    static Specification<City> countryCodeContains(String countryCode) {
        return (city, cq, cb) -> cb.like(cb.lower(city.get("countryCode")), "%" + countryCode.toLowerCase() + "%");
    }

    static Specification<City> populationGreaterThan(Integer populationSize) {
        return (city, cq, cb) -> cb.gt(city.get("population"), populationSize);
    }

    static Specification<City> populationLowerThan(Integer populationSize) {
        return (city, cq, cb) -> cb.lt(city.get("population"), populationSize);
    }
}
