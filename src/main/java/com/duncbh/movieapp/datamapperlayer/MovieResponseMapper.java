package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
}
