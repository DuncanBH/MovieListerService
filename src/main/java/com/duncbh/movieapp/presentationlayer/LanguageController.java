package com.duncbh.movieapp.presentationlayer;

import com.duncbh.movieapp.businesslayer.LanguageService;
import com.duncbh.movieapp.datalayer.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/languages")
    public List<LanguageResponseModel> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/languages/{languageId}")
    public LanguageResponseModel getLanguageById(@PathVariable int languageId) {
        return languageService.getLanguageById(languageId);
    }

    @GetMapping("/languages/{languageId}/movies")
    public List<LanguageMovieResponseModel> getMoviesByLanguage(@PathVariable int languageId) {
        return languageService.getMoviesByLanguageId(languageId);
    }

}
