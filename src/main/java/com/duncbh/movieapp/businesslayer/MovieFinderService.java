package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.datalayer.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieFinderService {
    List<Movie> findAllMovies();
    Movie addNewMovie(Movie movie);

    Optional<Movie> getMovieById(Long movId);

    Movie updateMovie(Movie movie, int movId);

    void deleteMovieById(int movId);
}
