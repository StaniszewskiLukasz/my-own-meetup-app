package sdajokessender.jokesassignment.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import sdajokessender.jokesassignment.dao.JokeModel;


public interface JokeRepository extends MongoRepository<JokeModel, String > {

}
