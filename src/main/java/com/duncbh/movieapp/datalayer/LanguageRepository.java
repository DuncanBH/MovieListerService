package com.duncbh.movieapp.datalayer;

import com.duncbh.movieapp.presentationlayer.LanguageMovieResponseModel;
import com.duncbh.movieapp.presentationlayer.LanguageResponseModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
    Language findLanguageByLanguageId(Integer languageId);
    Language findLanguageByName(String name);
}
