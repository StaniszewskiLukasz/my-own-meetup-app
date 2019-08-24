package pl.sda.meetup.myownmeetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.meetup.myownmeetup.dto.UserDto;
import javax.validation.Valid;

@Controller
public class RegisterController {


    @GetMapping({"/register","/register.html"})
    public String showRegister() {
//        model.addAttribute("register", new UserDto());
        return "register";
    }

   @PostMapping({"/register","/register.html"})
    public String handleRegister(@ModelAttribute @Valid UserDto userDto){
        //bindResult jest kubełkiem Springowym tam trafia błąd z walidacji, ale trzeba go obsłużyć po jeśli nie to
//       if (bindResult.hasErrors()) {
////           model.addAttribute("register", userDto);
//           return "error";
//       }
       return "event";
    }
}
