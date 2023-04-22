package com.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Director {

    private String Name;
    private Integer numberOfMovies;
    private Double imdbRating;

    public Director() { }

    public Director(String name, Integer numberOfMovies, Double imdbRating) {
        Name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}
