package com.example.springbackend.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.springbackend.controller.filter.CountryFilter;
import com.example.springbackend.repository.entity.Country;
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
@Sql("/insert-countries-for-testing.sql")
@Transactional
public class CountryQueryingIntegrationTest {

    @Autowired
    private CountryRepository countryRepository;

    private static Stream<Arguments> testArgumentsShouldFilterCountriesByCriteria() {
        return Stream.of(
                Arguments.of(null, null, null, null, List.of("Hungary", "Croatia", "Sweden", "Spain", "Netherlands", "Luxembourg", "Belgium", "Germany", "Slovenia", "Malta")),
                Arguments.of("l", null, null, null, List.of("Netherlands", "Belgium", "Luxembourg", "Malta")),
                Arguments.of("l", "a", null, null, List.of("Netherlands", "Malta")),
                Arguments.of("l", "a", 1_000_000, null, List.of("Malta")),
                Arguments.of("l", "a", null, 1_000_000, List.of("Netherlands")),
                Arguments.of("l", "a", 1_600_000, 800_000, List.of()),
                Arguments.of(null, null, null, 10_000_000, List.of("Sweden", "Spain", "Netherlands", "Belgium", "Germany"))
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsShouldFilterCountriesByCriteria")
    void shouldFilterCoutriesByCriteria(String countryCode, String countryName, Integer maxPopulation, Integer minPopulation, List<String> expectedCityNames) {
        // given
        CountryFilter cityFilter = new CountryFilter(countryCode, countryName, maxPopulation, minPopulation);

        // when
        List<Country> filtered = countryRepository.findByFilter(cityFilter);

        // then
        assertThat(filtered).extracting("name").containsExactlyInAnyOrderElementsOf(expectedCityNames);
    }
}
