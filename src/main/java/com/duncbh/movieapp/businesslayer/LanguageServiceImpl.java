package com.duncbh.movieapp.businesslayer;

import com.duncbh.movieapp.datalayer.Language;
import com.duncbh.movieapp.datalayer.LanguageRepository;
import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.datamapperlayer.LanguageMovieResponseMapper;
import com.duncbh.movieapp.datamapperlayer.LanguageResponseMapper;
import com.duncbh.movieapp.presentationlayer.LanguageMovieResponseModel;
import com.duncbh.movieapp.presentationlayer.LanguageResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageResponseMapper languageResponseMapper;
    @Autowired
    private LanguageMovieResponseMapper languageMovieResponseMapper;
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<LanguageResponseModel> getAllLanguages() {
        List<Language> languages = (List<Language>) languageRepository.findAll();
        return languageResponseMapper.entityListToResponseModelList(languages);
    }

    @Override
    public LanguageResponseModel getLanguageById(int languageId) {
        Language language = languageRepository.findLanguageByLanguageId(languageId);
        return languageResponseMapper.entityToResponseModel(language);
    }

    @Override
    public List<LanguageMovieResponseModel> getMoviesByLanguageId(int languageId) {
        Language language = languageRepository.findLanguageByLanguageId(languageId);
        List<Movie> movies = new ArrayList<>(language.getMovies());
        return languageMovieResponseMapper.entityListToResponseModelList(movies);
    }

}
