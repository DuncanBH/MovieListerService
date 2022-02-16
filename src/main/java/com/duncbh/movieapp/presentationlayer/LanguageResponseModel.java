package com.duncbh.movieapp.presentationlayer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class LanguageResponseModel extends RepresentationModel<LanguageResponseModel> {
    private Integer languageId;
    private String name;
}
