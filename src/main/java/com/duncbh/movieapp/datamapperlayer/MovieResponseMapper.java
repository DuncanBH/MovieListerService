package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.MovieResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {
    MovieResponseModel entityToResponseModel(Movie movie);
    List<MovieResponseModel> entityListToResponseModelList(List<Movie> movies);

    @Mapping(target = "id", ignore = true)
    Movie responseModelToEntity(MovieResponseModel model);
}
