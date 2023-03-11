package com.example.springbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$")
    private String code;

    @NotBlank
    @Pattern(regexp = "^[A-Z]\\w*$")
    private String name;

    @NotNull
//    @Pattern(regexp = "(\\u[0-9A-F]{4}){4}")
    private String flag;

    @NotNull
    @Positive
    private Integer population;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
