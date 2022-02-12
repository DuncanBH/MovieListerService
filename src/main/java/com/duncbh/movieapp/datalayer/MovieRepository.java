package com.duncbh.movieapp.datalayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Movie findMovieByMovieId(int movieId);
    boolean existsMovieByMovieId(int movieId);
    void deleteMovieByMovieId(int movieId);
}