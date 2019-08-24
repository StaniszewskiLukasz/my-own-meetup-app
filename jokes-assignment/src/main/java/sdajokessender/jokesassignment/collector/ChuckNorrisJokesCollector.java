package sdajokessender.jokesassignment.collector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sdajokessender.jokesassignment.dto.Joke;
import sdajokessender.jokesassignment.service.JokeService;


@Slf4j
@Service
@EnableScheduling
public class ChuckNorrisJokesCollector {

    private RestTemplate restTemplate = new RestTemplate();
    private final JokeService jokeService;

    public ChuckNorrisJokesCollector(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @Scheduled(cron = "* * * * * *")
    public void saveJokeFromChuckApi() {
        ResponseEntity<Joke> entity = restTemplate.getForEntity("http://api.icndb.com/jokes/random", Joke.class);
        Joke joke = entity.getBody();
        assert joke != null;
        log.info(joke.getValue().getJoke());
        jokeService.saveJoke(entity.getBody());

    }
}
