package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Language;
import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.LanguageController;
import com.duncbh.movieapp.presentationlayer.LanguageMovieResponseModel;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMovieResponseMapper {
    @Mappings({
            @Mapping(expression = "java(entity.getLanguage().getLanguageId())", target = "languageId")
    })
    LanguageMovieResponseModel entityToResponseModel(Movie entity);

    List<LanguageMovieResponseModel> entityListToResponseModelList(List<Movie> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Movie responseModelToEntity(LanguageMovieResponseModel model);

    @AfterMapping
    default void addLinks(@MappingTarget LanguageMovieResponseModel model, Movie entity) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .getLanguageById(model.getLanguageId()))
                .withSelfRel();

        Link movieLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .getMoviesByLanguage(entity.getMovieId()))
                .withRel("movies");

        model.setLinks(Links.of(selfLink, movieLink));
    }
}
