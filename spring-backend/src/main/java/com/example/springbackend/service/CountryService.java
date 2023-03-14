package com.example.springbackend.service;

import com.example.springbackend.controller.dto.CountryDTO;
import com.example.springbackend.controller.filter.CountryFilter;
import com.example.springbackend.repository.CountryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> findAll(CountryFilter filter) {
        return countryRepository.findByFilter(filter).stream()
                .map(CountryDTO::map)
                .toList();
    }
}
