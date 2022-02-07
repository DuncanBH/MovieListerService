package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.datalayer.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieFinderServiceImpl implements MovieFinderService {

    private MovieRepository movieRepository;

    @Autowired
    MovieFinderServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        return movies;
    }

    @Override
    public Movie addNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(Long movId) {
        Optional<Movie> movie = movieRepository.findById(movId.intValue() );
        return movie;
    }

    @Override
    public Movie updateMovie(Movie movie, int movId) {
        movie.setId(movId);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(int movId) {
        movieRepository.deleteById(movId);
    }
}
