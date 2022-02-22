package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.LanguageController;
import com.duncbh.movieapp.presentationlayer.MovieListerController;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {
    @Mappings({
            @Mapping(expression = "java(entity.getLanguage().getName().trim())", target = "lang")
    })
    MovieResponseModel entityToResponseModel(Movie entity);

    List<MovieResponseModel> entityListToResponseModelList(List<Movie> movies);

    @Mapping(target = "id", ignore = true)
    Movie responseModelToEntity(MovieResponseModel model);

    @AfterMapping
    default void addLinks(@MappingTarget MovieResponseModel model, Movie entity) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(MovieListerController.class)
                        .getMovieById(model.getMovieId()))
                .withSelfRel();

        Link langLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .getLanguageById(entity.getLanguage().getLanguageId()))
                .withRel("languages");

        model.setLinks(Links.of(selfLink, langLink));
    }
}
