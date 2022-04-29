package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.datalayer.Language;
import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.datalayer.MovieRepository;
import com.duncbh.movieapp.datamapperlayer.MovieResponseMapper;
import com.duncbh.movieapp.presentationlayer.MovieRequestModel;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovieFinderServiceImplTest {

    private Integer VALIDMOVIEID = 1;
    private String VALIDMOVIENAME = "Iron Man 3";
    private Integer VALIDMOVIEID2 = 2;
    private String VALIDMOVIENAME2 = "Spider Man 3";
    private Integer VALIDLANGUAGEID = 1;
    private String VALIDLANGUAGENAME = "English";

    @Autowired
    MovieFinderService movieFinderService;

    @MockBean
    MovieRepository movieRepository;

    @SpyBean
    MovieResponseMapper movieResponseMapper;

    @Test
    void whenFindAllMovies_thenReturnAllMovies() {
        //Arrange
        Language language = new Language();
        language.setLanguageId(VALIDLANGUAGEID);
        language.setName(VALIDLANGUAGENAME);

        Movie entity1 = new Movie();
        entity1.setMovieId(VALIDMOVIEID);
        entity1.setTitle(VALIDMOVIENAME);
        entity1.setLanguage(language);
        Movie entity2 = new Movie();
        entity2.setMovieId(VALIDMOVIEID2);
        entity2.setTitle(VALIDMOVIENAME2);
        entity2.setLanguage(language);

        List<Movie> entityList = List.of(new Movie[]{entity1, entity2});

        when(movieRepository.findAll()).thenReturn(entityList);

        //Act
        List<MovieResponseModel> returnedModels = movieFinderService.findAllMovies();

        //Assert
        assertEquals(entityList.get(0).getMovieId(), returnedModels.get(0).getMovieId());
        assertEquals(entityList.get(0).getTitle(), returnedModels.get(0).getTitle());

        assertEquals(entityList.get(1).getMovieId(), returnedModels.get(1).getMovieId());
        assertEquals(entityList.get(1).getTitle(), returnedModels.get(1).getTitle());
    }

    @Test
    void whenCreateMovie_thenGetMovieBack() {
        //Arrange
        Language language = new Language();
        language.setLanguageId(VALIDLANGUAGEID);
        language.setName(VALIDLANGUAGENAME);

        Movie entity = new Movie();
        entity.setMovieId(VALIDMOVIEID);
        entity.setTitle(VALIDMOVIENAME);
        entity.setLanguage(language);

        when(movieRepository.save(any(Movie.class))).thenReturn(entity);

        MovieRequestModel model = new MovieRequestModel();
        model.setTitle(VALIDMOVIENAME);
        model.setLang(VALIDLANGUAGENAME);

        //Act
        MovieResponseModel savedMovie = movieFinderService.createMovie(model);

        //Assert
        assertNotNull(savedMovie);
        assertEquals(entity.getMovieId(), savedMovie.getMovieId());
        assertEquals(entity.getTitle(), savedMovie.getTitle());
        assertEquals(entity.getTitle(), savedMovie.getTitle());
    }

    @Test
    void whenValidId_thenGetMovieById() {
        //Arrange
        Language language = new Language();
        language.setLanguageId(VALIDLANGUAGEID);
        language.setName(VALIDLANGUAGENAME);

        Movie entity = new Movie();
        entity.setMovieId(VALIDMOVIEID);
        entity.setTitle(VALIDMOVIENAME);
        entity.setLanguage(language);

        when(movieRepository.findMovieByMovieId(VALIDMOVIEID)).thenReturn(entity);
        when(movieRepository.existsMovieByMovieId(VALIDMOVIEID)).thenReturn(true);
        MovieRequestModel model = new MovieRequestModel();
        model.setTitle(VALIDMOVIENAME);
        model.setLang(VALIDLANGUAGENAME);

        //Act
        MovieResponseModel savedMovie = movieFinderService.getMovieById(VALIDMOVIEID);

        //Assert
        assertNotNull(savedMovie);
        assertEquals(entity.getMovieId(), savedMovie.getMovieId());
        assertEquals(entity.getTitle(), savedMovie.getTitle());
        assertEquals(entity.getTitle(), savedMovie.getTitle());
    }

    @Test
    void updateMovie() {
        //Arrange
        Language language = new Language();
        language.setLanguageId(VALIDLANGUAGEID);
        language.setName(VALIDLANGUAGENAME);

        Movie entity = new Movie();
        entity.setMovieId(VALIDMOVIEID);
        entity.setTitle(VALIDMOVIENAME);
        entity.setLanguage(language);

        when(movieRepository.findMovieByMovieId(VALIDMOVIEID)).thenReturn(entity);
        when(movieRepository.existsMovieByMovieId(VALIDMOVIEID)).thenReturn(true);
        when(movieRepository.save(any(Movie.class))).thenReturn(entity);

        MovieRequestModel model = new MovieRequestModel();
        model.setTitle(VALIDMOVIENAME);
        model.setLang(VALIDLANGUAGENAME);

        //Act
        MovieResponseModel savedMovie = movieFinderService.getMovieById(VALIDMOVIEID);

        //Assert
        assertNotNull(savedMovie);
        assertEquals(entity.getMovieId(), savedMovie.getMovieId());
        assertEquals(entity.getTitle(), savedMovie.getTitle());
        assertEquals(entity.getTitle(), savedMovie.getTitle());
    }

    @Test
    void deleteMovieById() {
        //Arrange
        Language language = new Language();
        language.setLanguageId(VALIDLANGUAGEID);
        language.setName(VALIDLANGUAGENAME);

        Movie entity = new Movie();
        entity.setMovieId(VALIDMOVIEID);
        entity.setTitle(VALIDMOVIENAME);
        entity.setLanguage(language);

        //when(movieRepository.save(any(Movie.class))).thenAnswer(i -> i.getArguments()[0]);
        when(movieRepository.existsMovieByMovieId(VALIDMOVIEID)).thenReturn(true);
        when(movieRepository.findMovieByMovieId(VALIDMOVIEID)).thenReturn(entity);

        //Act
        movieFinderService.deleteMovieById(VALIDMOVIEID);

        //Assert
        verify(movieRepository, times(1)).deleteMovieByMovieId(VALIDMOVIEID);
    }
}