package sdajokessender.jokesassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@NotNull
public class Joke {
    String type;
    @NotNull
    JokeValue value;
}
