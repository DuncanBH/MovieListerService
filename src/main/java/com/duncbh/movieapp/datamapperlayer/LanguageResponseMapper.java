package com.duncbh.movieapp.datamapperlayer;

import com.duncbh.movieapp.datalayer.Language;
import com.duncbh.movieapp.presentationlayer.LanguageResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
}
