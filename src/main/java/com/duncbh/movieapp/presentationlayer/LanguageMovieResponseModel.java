package com.duncbh.movieapp.presentationlayer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class LanguageMovieResponseModel extends RepresentationModel<LanguageMovieResponseModel> {
    private Integer languageId;
    private Integer movieId;
    private String title;
}
