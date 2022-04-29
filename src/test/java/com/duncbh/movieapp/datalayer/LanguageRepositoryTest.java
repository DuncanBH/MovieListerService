package com.duncbh.movieapp.datalayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class LanguageRepositoryTest {

    private final Integer VALIDLANGUAGEID = 1;
    private final Integer NOTFOUNDLANGUAGEID = 999;
    private final String VALIDLANGUAGENAME = "English";
    //class under test
    @Autowired
    LanguageRepository languageRepository;
    private Language savedEntity;

    @BeforeEach
    public void setupDb() {
        languageRepository.deleteAll();

        Language entity = new Language();
        entity.setLanguageId(VALIDLANGUAGEID);
        entity.setName(VALIDLANGUAGENAME);

        savedEntity = languageRepository.save(entity);

        assertEquals(entity.getLanguageId(), savedEntity.getLanguageId());
        assertEquals(entity.getName(), savedEntity.getName());
        assertNotNull(savedEntity.getId());
    }

    @Test
    void whenValidLanguageId_thenLanguageShouldBeFound() {
        //Arrange
        Language foundEntity;

        //Act
        foundEntity = languageRepository.findLanguageByLanguageId(VALIDLANGUAGEID);

        //Assert
        assertEquals(savedEntity.getLanguageId(), foundEntity.getLanguageId());
        assertEquals(savedEntity.getName(), foundEntity.getName());
        assertEquals(savedEntity.getId(), foundEntity.getId());

        //assertThat(savedEntity, samePropertyValuesAs(foundEntity));
    }

    @Test
    void whenSaveWithDuplicateLanguageId_thenThrowsDataIntegrityViolationException() {
        //Arrange
        Language entity = new Language();
        entity.setLanguageId(VALIDLANGUAGEID);
        entity.setName("Portuguese");

        //Act + Assert
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class,
                () -> {
                    languageRepository.save(entity);
                });
    }

    @Test
    void whenFindLanguageByName_thenReturnLanguageWithName() {
        //Arrange
        Language foundEntity;

        //Act
        foundEntity = languageRepository.findLanguageByName(VALIDLANGUAGENAME);

        //Assert
        assertEquals(savedEntity.getLanguageId(), foundEntity.getLanguageId());
        assertEquals(savedEntity.getName(), foundEntity.getName());
    }
}