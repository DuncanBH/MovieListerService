package com.duncbh.movieapp.presentationlayer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MovieResponseModel {
    private int movieId;
    private String title;
    private String director;
}
