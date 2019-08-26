package pl.sda.meetup.myownmeetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping({"/sign-in","/sign-in.html"})
    public String getSignIn() {
        return "sign-in";
    }
}


