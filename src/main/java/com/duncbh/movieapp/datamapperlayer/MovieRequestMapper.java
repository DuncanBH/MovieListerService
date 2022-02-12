package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Movie;
import com.duncbh.movieapp.presentationlayer.MovieRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MovieRequestMapper {
    MovieRequestModel entityToRequestModel(Movie movie);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "movieId", ignore = true)
    })
    Movie requestModelToEntity(MovieRequestModel model);
}
