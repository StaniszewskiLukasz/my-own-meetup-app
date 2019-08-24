package sdajokessender.jokesassignment.service;

import org.springframework.stereotype.Service;
import sdajokessender.jokesassignment.dto.Joke;
import sdajokessender.jokesassignment.repository.JokeRepository;

import static sdajokessender.jokesassignment.mapper.MapstructJokeMapper.INSTANCE;


@Service
public class JokeService {

    private final JokeRepository jokeRepository;

    public JokeService(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    public Joke saveJoke(Joke joke){
        return INSTANCE.jokeModelToJoke(jokeRepository.save(INSTANCE.jokeToJokeModel(joke)));
    }
}
