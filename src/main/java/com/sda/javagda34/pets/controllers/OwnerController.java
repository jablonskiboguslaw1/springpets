package com.sda.javagda34.pets.controllers;

import com.sda.javagda34.pets.model.Owner;
import com.sda.javagda34.pets.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;


    @GetMapping
    public String getOwnerForm(Model model, Owner owner) {
        model.addAttribute("owner",owner);
        return "ownerForm";
    }

    @PostMapping
    public String updateOwner(Owner owner){
        ownerService.update(owner);
        return "redirect:/owner/list";
    }

    @GetMapping("/list")
    public String showOwners(Model model){
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "ownerList";
    }
}
