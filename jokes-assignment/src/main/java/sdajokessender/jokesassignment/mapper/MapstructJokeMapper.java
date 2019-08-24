package sdajokessender.jokesassignment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import sdajokessender.jokesassignment.dao.JokeModel;
import sdajokessender.jokesassignment.dto.Joke;

@Mapper
public interface MapstructJokeMapper {
    MapstructJokeMapper INSTANCE = Mappers.getMapper(MapstructJokeMapper.class);

    @Mappings({
            @Mapping(source = "value.id", target = "externalId"),
            @Mapping(source = "value.joke", target = "value"),
            @Mapping(source = "value.categories", target = "categories")
    })
    JokeModel jokeToJokeModel(Joke joke);

    @Mappings({
            @Mapping(source = "externalId", target = "value.id"),
            @Mapping(source = "value", target = "value.joke"),
            @Mapping(source = "categories", target = "value.categories")
    })
    Joke jokeModelToJoke(JokeModel model);
}
