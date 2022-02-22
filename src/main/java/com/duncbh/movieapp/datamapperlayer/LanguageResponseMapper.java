package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Language;
import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.LanguageController;
import com.duncbh.movieapp.presentationlayer.LanguageResponseModel;
import com.duncbh.movieapp.presentationlayer.MovieListerController;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageResponseMapper {
    LanguageResponseModel entityToResponseModel(Language entity);

    List<LanguageResponseModel> entityListToResponseModelList(List<Language> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "movies", ignore = true)
    })
    Language responseModelToEntity(LanguageResponseModel model);

    @AfterMapping
    default void addLinks(@MappingTarget LanguageResponseModel model, Language entity) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .getLanguageById(model.getLanguageId()))
                .withSelfRel();

        model.setLinks(Links.of(selfLink));
    }
}
