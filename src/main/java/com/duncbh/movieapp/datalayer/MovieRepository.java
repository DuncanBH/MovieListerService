package com.duncbh.movieapp.datalayer;

import com.duncbh.movieapp.presentationlayer.MovieRequestModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Movie findMovieByMovieId(int movieId);
    boolean existsMovieByMovieId(int movieId);
    void deleteMovieByMovieId(int movieId);
}