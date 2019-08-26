package pl.sda.meetup.myownmeetup.service;

import org.springframework.stereotype.Service;
import pl.sda.meetup.myownmeetup.converters.UserDtoToUserModel;
import pl.sda.meetup.myownmeetup.dao.UserModel;
import pl.sda.meetup.myownmeetup.dto.UserDto;
import pl.sda.meetup.myownmeetup.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoToUserModel userDtoToUserModel;

    public UserServiceImpl(UserRepository userRepository, UserDtoToUserModel userDtoToUserModel) {
        this.userRepository = userRepository;
        this.userDtoToUserModel = userDtoToUserModel;
    }

    @Override
    public void save(UserDto userDto) {
//        UserModel userModel = userDtoToUserModel.convert(userDto);
//        userRepository.save(userModel);
    }
}
