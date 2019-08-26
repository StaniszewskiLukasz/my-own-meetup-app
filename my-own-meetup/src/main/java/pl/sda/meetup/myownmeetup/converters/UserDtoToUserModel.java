package pl.sda.meetup.myownmeetup.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.meetup.myownmeetup.dao.UserModel;
import pl.sda.meetup.myownmeetup.dto.UserDto;

@Component
public class UserDtoToUserModel implements Converter<UserDto, UserModel> {

    private final PasswordEncoder passwordEncoder;

    public UserDtoToUserModel(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserModel convert(UserDto source) {
        if (source == null) {
            return null;
        }
        final UserModel userModel = new UserModel();
        userModel.setName(source.getName());
        userModel.setEmail(source.getEmail());
        userModel.setPassword(passwordEncoder.encode(source.getPassword()));
        return userModel;
    }
}
