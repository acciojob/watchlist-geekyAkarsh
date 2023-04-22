package com.driver;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){

        try{
            Boolean added = movieService.addMovie(movie);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } catch(Exception exception){
            return new ResponseEntity<>("Something went wrong", HttpStatus.valueOf(500));
        }
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){

        try{
            Boolean added = movieService.addDirector(director);
            return new ResponseEntity("success",HttpStatus.OK);
        } catch(Exception exception){
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName,
                                               @RequestParam String directorName){

        try{
            Boolean paired = movieService.addMovieDirectorPair(movieName,directorName);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } catch(Exception exception){
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){

        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity(movie,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){

        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity(director,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){

        try{
            List<String> movies = movieService.getMoviesByDirectorName(director);
            return new ResponseEntity(movies,HttpStatus.OK);
        } catch(Exception exception){
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){

        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity(movies,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name){

        Boolean deleted = movieService.deleteDirectorByName(name);
        return new ResponseEntity("success",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){

        try{
            Boolean deleted = movieService.deleteAllDirectors();
            return new ResponseEntity("success",HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity("Something went wrong", HttpStatus.valueOf(500));
        }
    }

}
