package com.example.springbackend.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.springbackend.controller.filter.CityFilter;
import com.example.springbackend.repository.entity.City;
import java.util.List;
import java.util.stream.Stream;
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
@Sql(scripts = {
        "/insert-countries-for-testing.sql",
        "/insert-cities-for-testing.sql"
})
@Transactional
class CityQueryingIntegrationTest {

    @Autowired
    private CityRepository cityRepository;

    private static Stream<Arguments> testArgumentsShouldFilterCitiesByCriteria() {
        return Stream.of(
                Arguments.of(null, null, null, null, null, List.of("Utrecht", "Luxembourg", "Antwerp", "Berlin", "Hamburg", "Munich", "Cologne", "Frankfurt am Main", "Stuttgart", "Düsseldorf", "Budapest", "Zagreb", "Stockholm", "Gothenburg", "Malmö", "Madrid", "Barcelona", "Valencia", "Seville", "Zaragoza")),
                Arguments.of(null, null, null, null, true, List.of("Luxembourg", "Berlin", "Antwerp", "Budapest", "Stockholm", "Madrid", "Zagreb")),
                Arguments.of(null, null, null, null, false, List.of("Utrecht", "Hamburg", "Munich", "Cologne", "Frankfurt am Main", "Stuttgart", "Düsseldorf", "Gothenburg", "Malmö", "Barcelona", "Valencia", "Seville", "Zaragoza")),
                Arguments.of("ar", null, null, null, null, List.of("Stuttgart", "Barcelona", "Zaragoza")),
                Arguments.of("ar", "ai", null, null, null, List.of("Zaragoza", "Barcelona")),
                Arguments.of("ar", "ai", 1_000_000, null, null, List.of("Zaragoza")),
                Arguments.of("ar", "ai", null, 1_000_000, null, List.of("Barcelona")),
                Arguments.of("ar", "ai", 1_600_000, 800_000, null, List.of()),
                Arguments.of(null, null, null, 3_000_000, null, List.of("Madrid", "Berlin"))
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsShouldFilterCitiesByCriteria")
    void shouldFilterCitiesByCriteria(String cityName, String countryCode, Integer maxPopulation, Integer minPopulation, Boolean isCapital, List<String> expectedCityNames) {
        // given
        CityFilter cityFilter = new CityFilter(cityName, countryCode, maxPopulation, minPopulation, isCapital);

        // when
        List<City> filtered = cityRepository.findByFilter(cityFilter);

        // then
        assertThat(filtered).extracting("name").containsExactlyInAnyOrderElementsOf(expectedCityNames);
    }
}
