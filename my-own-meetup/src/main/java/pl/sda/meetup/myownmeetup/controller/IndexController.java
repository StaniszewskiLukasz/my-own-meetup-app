package pl.sda.meetup.myownmeetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex() {

        return "index";
    }

    @GetMapping("/restricted")
    public String restrictedPage() {
        return "restricted";
    }
}
