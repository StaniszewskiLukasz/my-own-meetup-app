package pl.sda.meetup.myownmeetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.meetup.myownmeetup.converters.UserDtoToUserModel;
import pl.sda.meetup.myownmeetup.dao.UserModel;
import pl.sda.meetup.myownmeetup.dto.UserDto;
import pl.sda.meetup.myownmeetup.repository.UserRepository;
import pl.sda.meetup.myownmeetup.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
//@RequiredArgsConstructor on tworzy konstruktora tylko do pól oznaczonych jako final
public class RegisterController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final UserDtoToUserModel userDtoToUserModel;

    public RegisterController(UserRepository userRepository, UserServiceImpl userService,
                              UserDtoToUserModel userDtoToUserModel1) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.userDtoToUserModel = userDtoToUserModel1;
    }


    @GetMapping({"/registerForm","/registerForm.html"})
    public String showRegister(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "registerForm";
    }

   @PostMapping({"/registerForm","/registerForm.html"})
    public String handleRegister(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult){
//        bindingResult to koszyczek do którego wpadają dane walidacji
       if (bindingResult.hasErrors()) {
           return "registerForm";
       }
       UserModel userModel = userDtoToUserModel.convert(userDto);
       userRepository.save(userModel);

//       return "event";//jeśli tu zrobie beżpośrednio event to będę wyświetlał nową stronę
       // ale pod starym adresem rejestrowania czyli będe podwójnie wysyłał dane rejestracji na serwer
       return "redirect:/event";//taj jest dobrze
    }

    @GetMapping("/event")
    public String redirectAfterRegister(){
        return "event";
    }
}
