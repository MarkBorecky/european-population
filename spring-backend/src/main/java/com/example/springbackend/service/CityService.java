package com.example.springbackend.service;

import com.example.springbackend.controller.filter.CityFilter;
import com.example.springbackend.controller.dto.CityDTO;
import com.example.springbackend.repository.CityRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> findByFilter(CityFilter filter) {
        return cityRepository.findByFilter(filter).stream()
                .map(CityDTO::map)
                .toList();
    }
}
