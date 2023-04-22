package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Boolean addMovie(Movie movie) {

        movieRepository.addMovie(movie);
        return true;
    }

    public Boolean addDirector(Director director) {

        movieRepository.addDirector(director);
        return true;
    }

    public Boolean addMovieDirectorPair(String movieName, String directorName) {

        movieRepository.addMovieDirectorPair(movieName,directorName);
        return true;
    }

    public Movie getMovieByName(String name) {

        Optional<Movie> movie = movieRepository.getMovieByName(name);
        return movie.get();
    }

    public Director getDirectorByName(String name) {

        Optional<Director> director = movieRepository.getDirectorByName(name);
        return director.get();
    }

    public List<String> getMoviesByDirectorName(String name) {

        List<String> movies = movieRepository.getMoviesByDirectorName(name);
        return movies;
    }

    public List<String> findAllMovies() {

        Set<String> set = movieRepository.getAllMovies();
        List<String> ans = new ArrayList<>();

        for(String movie : set){
            ans.add(movie);
        }
        return ans;
    }

    public Boolean deleteDirectorByName(String name) {

        List<String> movies = getMoviesByDirectorName(name);
        if(movies.size() != 0) {
            for (String movie : movies) {
                movieRepository.deleteMovieByName(movie);
            }
        }
        movieRepository.deleteDirectorByName(name);
        return true;
    }


    public Boolean deleteAllDirectors() {

        List<String> directors = getAllDirectors();
        System.out.println(directors.size());
        if(directors.size()>0) {
            for (String director : directors) {
                System.out.println("Director is : " + director);
                deleteDirectorByName(director);
            }
        }
        return true;
    }

    public List<String> getAllDirectors() {

        Set<String> directors = movieRepository.getAllDirectors();
        List<String> ans = new ArrayList<>();

        for(String director : directors){
            ans.add(director);
        }
        return ans;
    }
}
