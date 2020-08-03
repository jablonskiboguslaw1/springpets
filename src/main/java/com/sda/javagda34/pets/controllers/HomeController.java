package com.sda.javagda34.pets.controllers;

import com.sda.javagda34.pets.model.Race;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping
    public String welcome( Model model){
       model.addAttribute("races", Race.values());
        return "index";
    }
}
