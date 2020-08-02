package com.sda.javagda34.pets.Controllers;

import com.sda.javagda34.pets.model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @GetMapping
    public String getOwnerForm(Model model, Owner owner) {

        model.addAttribute("owner",owner);
        return "ownerForm";



    }

}
