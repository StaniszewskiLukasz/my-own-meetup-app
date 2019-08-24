package sdajokessender.jokesassignment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JokeValue {
    Integer id;
    String joke;
    String[] categories;
}
