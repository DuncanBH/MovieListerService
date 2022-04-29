package com.duncbh.movieapp.datalayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class MovieRepositoryTest {

    private final Integer VALIDMOVIEID = 1;
    private final Integer NOTFOUNDMOVIEID = 999;
    private final String VALIDMOVIENAME = "Iron Man";
    private final String VALIDMOVIELANGUAGE = "English";

    @Autowired
    LanguageRepository languageRepository;

    //class under test
    @Autowired
    MovieRepository movieRepository;
    private Movie savedEntity;

    @BeforeEach
    public void setupDb() {
        movieRepository.deleteAll();
        languageRepository.deleteAll();

        Language languageEntity = new Language();
        languageEntity.setLanguageId(101);
        languageEntity.setName(VALIDMOVIELANGUAGE);

        Language savedLanguage = languageRepository.save(languageEntity);

        Movie entity = new Movie();
        entity.setMovieId(VALIDMOVIEID);
        entity.setTitle(VALIDMOVIENAME);
        entity.setLanguage(savedLanguage);

        savedEntity = movieRepository.save(entity);

        assertEquals(entity.getMovieId(), savedEntity.getMovieId());
        assertEquals(entity.getTitle(), savedEntity.getTitle());
        assertNotNull(savedEntity.getId());
    }

    @Test
    void whenValidId_thenFindMovieByMovieId() {
        //Arrange
        Movie foundEntity;

        //Act
        foundEntity = movieRepository.findMovieByMovieId(VALIDMOVIEID);

        //Assert
        assertEquals(savedEntity.getId(), foundEntity.getId());
        assertEquals(savedEntity.getMovieId(), foundEntity.getMovieId());
        assertEquals(savedEntity.getTitle(), foundEntity.getTitle());
    }

    @Test
    void whenValidId_returnTrue() {
        //Arrange
        Boolean result;

        //Act
        result = movieRepository.existsMovieByMovieId(VALIDMOVIEID);

        //Assert
        assertTrue(result);
    }

    @Test
    void whenValidId_thenDeleteMovieByMovieId() {
        //Arrange
        Movie foundEntity = movieRepository.findMovieByMovieId(VALIDMOVIEID);
        assertNotNull(foundEntity);

        //act
        movieRepository.delete(foundEntity);
        foundEntity = movieRepository.findMovieByMovieId(VALIDMOVIEID);

        //Assert
        assertNull(foundEntity);
    }
}