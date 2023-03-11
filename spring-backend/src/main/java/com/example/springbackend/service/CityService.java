package com.example.springbackend.service;

import static com.example.springbackend.repository.CityRepository.*;
import static io.vavr.API.Tuple;
import static java.util.Objects.nonNull;
import static org.springframework.data.jpa.domain.Specification.allOf;
import com.example.springbackend.model.City;
import com.example.springbackend.model.CityWithCountry;
import com.example.springbackend.repository.CityRepository;
import io.vavr.Tuple2;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityWithCountry> findWithCitiesPopulationGreaterThan(Integer minimalPopulation) {
        return cityRepository.findWithCitiesPopulationGreaterThan(minimalPopulation);
    }

    public List<City> findByCriteria(String cityName, String countryCode, Integer populationLowerThan, Integer populationGreaterThan) {
        List<Specification<City>> specifications = Stream.of(
                        Tuple(nonNull(cityName), cityNameContains(cityName)),
                        Tuple(nonNull(countryCode), countryCodeContains(countryCode)),
                        Tuple(nonNull(populationLowerThan), populationLowerThan(populationLowerThan)),
                        Tuple(nonNull(populationGreaterThan), populationGreaterThan(populationGreaterThan))
                ).filter(Tuple2::_1)
                .map(Tuple2::_2)
                .toList();

        return cityRepository.findAll(allOf(specifications));
    }
}
