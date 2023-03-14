package com.example.springbackend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.springbackend.controller.dto.CityDTO;
import com.example.springbackend.service.CityService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CityController.class)
class CityControllerTest {

    public static final String API_V_1_CITIES = "/api/v1/cities";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService service;

    @Test
    public void negativePopulationLowerThanShouldRaiseClientError() throws Exception {
        this.mockMvc.perform(post(API_V_1_CITIES).contentType(MediaType.APPLICATION_JSON)
                .content("""
                            {
                                "populationLowerThan": -1
                            }
                        """)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void negativePopulationGreaterThanShouldRaiseClientError() throws Exception {
        this.mockMvc.perform(post(API_V_1_CITIES).contentType(MediaType.APPLICATION_JSON)
                .content("""
                            {
                                "populationGreaterThan": -1
                            }
                        """)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void emptyFilterShouldReturnAllResults() throws Exception {
        when(service.findByFilter(any()))
                .thenReturn(List.of(new CityDTO("Finland", "Helsinki", 664921, true)));
        this.mockMvc.perform(post(API_V_1_CITIES).contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].country").value("Finland"))
                .andExpect(jsonPath("$[0].city").value("Helsinki"))
                .andExpect(jsonPath("$[0].population").value("664921"))
                .andExpect(jsonPath("$[0].is_capital").value("true"));
    }

}