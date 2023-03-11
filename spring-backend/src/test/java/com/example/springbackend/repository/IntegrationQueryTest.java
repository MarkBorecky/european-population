package com.example.springbackend.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import com.example.springbackend.model.City;
import com.example.springbackend.model.CityWithCountry;
import com.example.springbackend.service.CityService;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(properties = {
        "spring.jpa.show-sql=true",
        "spring.jpa.properties.hibernate.format_sql=true"
})
@Sql("/insert-test-data.sql")
@Transactional
class IntegrationQueryTest {

    @Autowired
    private CityService cityService;

    @Test
    void shouldFilterGreaterCitiesThan3_000_000() {
        //when
        List<CityWithCountry> filteredCities = cityService.findWithCitiesPopulationGreaterThan(3_000_000);

        //then
        Assertions.assertThatList(filteredCities).extracting("country", "city")
                .containsOnly(
                        tuple("Spain", "Madrid"),
                        tuple("Germany", "Berlin")
                );
    }

    @ParameterizedTest
    @MethodSource("methodForArguments")
    void shouldFilterCitiesByCriteria(String cityName, String CountryCode, Integer maxPopulation, Integer minPopulation, List<String> expectedCityNames) {
        //when
        List<City> citiesCriteria = cityService.findByCriteria(cityName, CountryCode, maxPopulation, minPopulation);

        //then
        assertThat(citiesCriteria).extracting("name").containsExactlyInAnyOrderElementsOf(expectedCityNames);
    }

    private static Stream<Arguments> methodForArguments() {
        return Stream.of(
                Arguments.of(null, null, null, null, List.of("Utrecht", "Luxembourg", "Antwerp", "Berlin", "Hamburg", "Munich", "Cologne", "Frankfurt am Main", "Stuttgart", "Düsseldorf", "Budapest", "Zagreb", "Stockholm", "Gothenburg", "Malmö", "Madrid", "Barcelona", "Valencia", "Seville", "Zaragoza")),
                Arguments.of("ar", null, null, null, List.of("Stuttgart", "Barcelona", "Zaragoza")),
                Arguments.of("ar", "Es", 1_000_000, null, List.of("Zaragoza")),
                Arguments.of("ar", "Es", null, 1_000_000, List.of("Barcelona")),
                Arguments.of("ar", "Es", 1_600_00, 800_000, List.of())
        );
    }

}