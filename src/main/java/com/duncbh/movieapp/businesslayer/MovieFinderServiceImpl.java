package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.datalayer.LanguageRepository;
import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.datalayer.MovieRepository;
import com.duncbh.movieapp.datamapperlayer.MovieRequestMapper;
import com.duncbh.movieapp.datamapperlayer.MovieResponseMapper;
import com.duncbh.movieapp.presentationlayer.MovieRequestModel;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MovieFinderServiceImpl implements MovieFinderService {

    final int LENGTH_ID = 8;
    @Autowired
    private MovieRequestMapper movieRequestMapper;

    @Autowired
    private MovieResponseMapper movieResponseMapper;


    private MovieRepository movieRepository;
    private LanguageRepository languageRepository;

    @Autowired
    MovieFinderServiceImpl(MovieRepository movieRepository, LanguageRepository languageRepository) {
        this.movieRepository = movieRepository;
        this.languageRepository = languageRepository;
    }


    @Override
    public List<MovieResponseModel> findAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        return movieResponseMapper.entityListToResponseModelList(movies);
    }

    @Override
    public MovieResponseModel createMovie(MovieRequestModel requestModel) {
        Movie movie = movieRequestMapper.requestModelToEntity(requestModel);

        String shortIdString = RandomStringUtils.randomNumeric(LENGTH_ID);
        Integer shortId = Integer.valueOf(shortIdString);

        movie.setMovieId(shortId);

        movie.setLanguage(languageRepository.findLanguageByName(requestModel.getLang()));
        //return saved movie (as model)
        return movieResponseMapper.entityToResponseModel(movieRepository.save(movie));
    }

    @Override
    public MovieResponseModel getMovieById(int movId) {
        Movie movie = movieRepository.findMovieByMovieId(movId);

        return movieResponseMapper.entityToResponseModel(movie);
    }

    @Override
    public MovieResponseModel updateMovie(MovieRequestModel movie, int movId) {
        //guard clause to check movie is in DB before updating
        if (!movieRepository.existsMovieByMovieId(movId)) { return null;}

        //Get old movie
        Movie oldMovie = movieRepository.findMovieByMovieId(movId);

        //Copy movieId of old to new
        Movie newMovie = movieRequestMapper.requestModelToEntity(movie);
        newMovie.setId(oldMovie.getId());
        newMovie.setMovieId(movId);

        //Set Language
        newMovie.setLanguage(languageRepository.findLanguageByName(movie.getLang()));
        //save movie, convert to then return model
        return movieResponseMapper.entityToResponseModel(movieRepository.save(newMovie));
    }

    @Transactional
    @Override
    public void deleteMovieById(int movId) {
        //guard clause to check movie is in DB before updating
        if (!movieRepository.existsMovieByMovieId(movId)) { throw new EntityNotFoundException("Invalid MovieId was provided");}

        movieRepository.deleteMovieByMovieId(movId);
    }
}
