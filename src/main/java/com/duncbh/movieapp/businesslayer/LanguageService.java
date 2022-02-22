package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.presentationlayer.LanguageMovieResponseModel;
import com.duncbh.movieapp.presentationlayer.LanguageResponseModel;

import java.util.List;

public interface LanguageService {
    List<LanguageResponseModel> getAllLanguages();
    LanguageResponseModel getLanguageById(int languageId);
    List<LanguageMovieResponseModel> getMoviesByLanguageId(int languageId);

}
