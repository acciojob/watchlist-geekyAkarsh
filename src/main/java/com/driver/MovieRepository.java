package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private Map<String,Movie> movies = new HashMap<>();
    private Map<String,Director> directors = new HashMap<>();
    private Map<String, ArrayList<String>> dirMovieMap = new HashMap<>();


    public void addMovie(Movie movie) {

        String name = movie.getName();
        movies.put(name,movie);
        return;
    }

    public void addDirector(Director director) {

        String name = director.getName();
        directors.put(name,director);
        return;
    }

    public void addMovieDirectorPair(String movieName, String directorName) {

        ArrayList<String> old;
        if(dirMovieMap.containsKey(directorName)){
            old = dirMovieMap.get(directorName);
        }else{
            old = new ArrayList<>();
        }

        for(String name : old){
            if(name.equals(movieName)) return;
        }

        old.add(movieName);
        dirMovieMap.put(directorName,old);
        return;
    }

    public Optional<Movie> getMovieByName(String name) {

        if(movies.containsKey(name)){
            return Optional.of(movies.get(name));
        }

        return Optional.empty();
    }

    public Optional<Director> getDirectorByName(String name) {

        if(directors.containsKey(name)){
            return Optional.of(directors.get(name));
        }

        return Optional.empty();
    }

    public List<String> getMoviesByDirectorName(String name) {

        List<String> ans;
        if(dirMovieMap.containsKey(name)){
            ans = dirMovieMap.get(name);
        }else{
            ans = new ArrayList<>();
        }
        return ans;
    }

    public Set<String> getAllMovies() {

        return movies.keySet();
    }

    public Set<String> getAllDirectors(){

        return directors.keySet();
    }

    public void deleteMovieByName(String name){

        if(movies.containsKey(name))
            movies.remove(name);
        return;
    }

    public void deleteDirectorByName(String name){

        if(directors.containsKey(name))
            directors.remove(name);
        if(dirMovieMap.containsKey(name))
            dirMovieMap.remove(name);
        return;
    }

}
