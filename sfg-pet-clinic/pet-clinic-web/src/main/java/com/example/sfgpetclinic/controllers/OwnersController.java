package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")//jeśli i tak wszystkie requesty mają zawierać owners to tu możemy dla całej klasy zrobić deklaracje
@Controller                 //moim zdaniem to dublowanie adnotacji i zaśmiecanie kodu bo i tak na dole trzeba podać
public class OwnersController {//pusty string

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index"})
    public String listOfOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());//owners w tej lini mapuje pole w pliku html
        return "owners/index";                                           //z tą samą nazwą pole to przyjmie wszystkie
    }//elementy uzyskane z metody ownerService.findALL

    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }
}
