package com.duncbh.movieapp.presentationlayer;

import com.duncbh.movieapp.businesslayer.MovieFinderService;
import com.duncbh.movieapp.datalayer.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieListerController {

    @Autowired
    private MovieFinderService movieFinderService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieFinderService.findAllMovies();
        return movies;
    }

    @GetMapping("/movies/{movId}")
    public Optional<Movie> getMovieById(@PathVariable Long movId) {
        Optional<Movie> movie = movieFinderService.getMovieById(movId);
        return movie;
    }

    @PostMapping("/movies")
    public Movie newMovie(@RequestBody Movie movie) {
        return movieFinderService.addNewMovie(movie);
    }

    @PutMapping("/movies/{movId}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable int movId) {
        return movieFinderService.updateMovie(movie, movId);
    }

    @DeleteMapping("/movies/{movId}")
    public void deleteMovie(@PathVariable int movId) {
        movieFinderService.deleteMovieById(movId);
    }

}