package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.datalayer.Language;
import com.duncbh.movieapp.datalayer.LanguageRepository;
import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.datamapperlayer.LanguageResponseMapper;
import com.duncbh.movieapp.presentationlayer.LanguageMovieResponseModel;
import com.duncbh.movieapp.presentationlayer.LanguageResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class LanguageServiceImplTest {

    @Autowired
    LanguageService languageService;

    @MockBean
    LanguageRepository languageRepository;

    @SpyBean
    LanguageResponseMapper languageResponseMapper;

    @Test
    void whenGetAllLanguages_thenReturnAllLanguages() {
        //Arrange
        Language entity1 = new Language();
        entity1.setLanguageId(1);
        entity1.setName("English");
        Language entity2 = new Language();
        entity2.setLanguageId(2);
        entity2.setName("French");

        List<Language> entityList = List.of(new Language[]{entity1, entity2});

        when(languageRepository.findAll()).thenReturn(entityList);

        //Act
        List<LanguageResponseModel> returnedModels = languageService.getAllLanguages();

        //Assert
        assertEquals(entityList.get(0).getLanguageId(), returnedModels.get(0).getLanguageId());
        assertEquals(entityList.get(0).getName(), returnedModels.get(0).getName());

        assertEquals(entityList.get(1).getLanguageId(), returnedModels.get(1).getLanguageId());
        assertEquals(entityList.get(1).getName(), returnedModels.get(1).getName());
    }

    @Test
    void whenValidId_thenGetLanguageResponseModelById() {
        //Arrange
        Integer languageId = 101;

        String languageName = "English";
        Language entity = new Language();
        entity.setLanguageId(languageId);
        entity.setName(languageName);

        LanguageResponseModel languageResponseModel;

        when(languageRepository.findLanguageByLanguageId(languageId)).thenReturn(entity);

        //Act
        languageResponseModel = languageService.getLanguageById(languageId);

        //Assert
        assertEquals(entity.getLanguageId(), languageResponseModel.getLanguageId());
        assertEquals(entity.getName(), languageResponseModel.getName());

        verify(languageResponseMapper, times(1)).entityToResponseModel(any(Language.class));
    }

    @Test
    void whenValidId_thenGetLanguageMoviesResponseModelByLanguageId() {
        //Arrange
        Integer languageId = 101;
        String languageName = "English";

        Language entity = new Language();
        entity.setLanguageId(languageId);
        entity.setName(languageName);

        Movie movie1 = new Movie();
        movie1.setMovieId(1);
        movie1.setTitle("Iron Man 1");
        movie1.setLanguage(entity);
        Movie movie2 = new Movie();
        movie2.setMovieId(2);
        movie2.setTitle("Iron Man 2");
        movie2.setLanguage(entity);

        Set<Movie> entityMovies = Set.of(new Movie[]{movie1, movie2});
        entity.setMovies(entityMovies);

        when(languageRepository.findLanguageByLanguageId(languageId)).thenReturn(entity);

        //Act
        List<LanguageMovieResponseModel> movieResponseModels = languageService.getMoviesByLanguageId(languageId);

        //Assert
        assertNotNull(movieResponseModels);
    }
}