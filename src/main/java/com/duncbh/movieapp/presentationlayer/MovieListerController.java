package com.duncbh.movieapp.presentationlayer;

import com.duncbh.movieapp.businesslayer.MovieFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieListerController {

    @Autowired
    private MovieFinderService movieFinderService;

    @GetMapping("/movies")
    @Transactional
    public List<MovieResponseModel> getAllMovies() {
        List<MovieResponseModel> movies = movieFinderService.findAllMovies();
        return movies;
    }

    @GetMapping("/movies/{movId}")
    public MovieResponseModel getMovieById(@PathVariable int movId) {
        MovieResponseModel movie = movieFinderService.getMovieById(movId);
        return movie;
    }

    @PostMapping("/movies")
    public MovieResponseModel newMovie(@RequestBody MovieRequestModel movie) {
        return movieFinderService.createMovie(movie);
    }

    @PutMapping("/movies/{movId}")
    public MovieResponseModel updateMovie(@RequestBody MovieRequestModel movie, @PathVariable int movId) {
        return movieFinderService.updateMovie(movie, movId);
    }

    @DeleteMapping("/movies/{movId}")
    public void deleteMovie(@PathVariable int movId) {
        movieFinderService.deleteMovieById(movId);
    }

}