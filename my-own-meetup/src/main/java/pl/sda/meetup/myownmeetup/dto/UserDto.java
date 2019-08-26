package pl.sda.meetup.myownmeetup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NotNull(message = "Pole nie może być puste")
public class UserDto {

    @Size(max = 50,message = "Nazwa może mieć maksymalnie 50 znaków")
    private String name;
//    @Pattern(regexp = ".+@.+")
    private String email;
    @Size(min = 8, max = 30, message
            = "Hasło musi mieć przynajmniej 8 znaków, ale nie więcej niż 30")
    private String password;
}
