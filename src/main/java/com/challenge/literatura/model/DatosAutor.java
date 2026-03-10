package com.challenge.literatura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(

        String name,

        @JsonAlias("birth_year")
        Integer birthYear,

        @JsonAlias("death_year")
        Integer deathYear
) {
}
