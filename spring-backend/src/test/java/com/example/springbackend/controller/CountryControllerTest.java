package com.example.springbackend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.springbackend.controller.dto.CountryDTO;
import com.example.springbackend.service.CountryService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    public static final String API_V_1_COUNTRIES = "/api/v1/countries";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService service;

    @Test
    public void negativePopulationLowerThanShouldRaiseClientError() throws Exception {
        this.mockMvc.perform(post(API_V_1_COUNTRIES).contentType(MediaType.APPLICATION_JSON)
                .content("""
                            {
                                "populationLowerThan": -1
                            }
                        """)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void negativePopulationGreaterThanShouldRaiseClientError() throws Exception {
        this.mockMvc.perform(post(API_V_1_COUNTRIES).contentType(MediaType.APPLICATION_JSON)
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
                .thenReturn(List.of(new CountryDTO("FIC", "Fiction", "EMOJI", 1)));
        this.mockMvc.perform(post(API_V_1_COUNTRIES).contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].countryCode").value("FIC"))
                .andExpect(jsonPath("$[0].countryName").value("Fiction"))
                .andExpect(jsonPath("$[0].flagEmoji").value("EMOJI"))
                .andExpect(jsonPath("$[0].population").value(1));
    }

}
