package com.duncbh.movieapp.presentationlayer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MovieRequestModel {
    private String title;
    private String director;
    private String lang;
}
