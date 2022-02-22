package com.duncbh.movieapp.presentationlayer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@Setter
@Getter
public class MovieResponseModel extends RepresentationModel<MovieResponseModel> {
    private int movieId;
    private String title;
    private String director;
    private String lang;
    private Links links;
}
