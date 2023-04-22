package com.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    private String Name;
    private Integer durationInMinutes;
    private Double imdbRating;

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.Name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }


}
