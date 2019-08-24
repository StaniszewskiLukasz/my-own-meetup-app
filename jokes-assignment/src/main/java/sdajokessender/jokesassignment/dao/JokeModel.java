package sdajokessender.jokesassignment.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
//@Entity
@Document(collection = "jokes")
public class JokeModel {
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    Integer id;
    Integer externalId;
    String value;
//    @Transient
    List<String> categories = new ArrayList<>();
}
