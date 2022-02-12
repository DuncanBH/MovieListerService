package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.presentationlayer.MovieRequestModel;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;

import java.util.List;

public interface MovieFinderService {
    MovieResponseModel getMovieById(int movId);

    List<MovieResponseModel> findAllMovies();

    MovieResponseModel createMovie(MovieRequestModel movie);

    MovieResponseModel updateMovie(MovieRequestModel movie, int movId);

    void deleteMovieById(int movId);
}
