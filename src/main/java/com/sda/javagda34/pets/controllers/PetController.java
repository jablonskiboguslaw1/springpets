package com.sda.javagda34.pets.controllers;

import com.sda.javagda34.pets.model.Owner;
import com.sda.javagda34.pets.model.Pet;
import com.sda.javagda34.pets.model.Race;
import com.sda.javagda34.pets.services.OwnerService;
import com.sda.javagda34.pets.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;

    @GetMapping
    public String getPetForm(Model model, Pet pet, @RequestParam(name = "id",required = false) Long id, @RequestParam(name = "ownerId", required = false) Long ownerId) {
if(id!=null) pet=petService.findById(id).get();

        model.addAttribute("pet", pet);
        model.addAttribute("ownerId", ownerId);
        model.addAttribute("raceList", Arrays.asList(Race.values()));
        model.addAttribute("owners", ownerService.findAll());


        return "petForm";
    }

    @PostMapping
    public String addPet(Pet pet, Long ownerId) {
        Optional<Owner> optionalOwner = ownerService.findById(ownerId);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            pet.setOwner(owner);
            petService.update(pet);
           return "redirect:/owner/details?id=" + ownerId;
        }
        return "redirect:/owner/list";

    }

    @GetMapping("/list")
    public String getPetList(Model model) {
        List<Pet> pets = petService.findAll();
        model.addAttribute("pets", pets);
        return "petList";
    }

    @GetMapping("/delete")
    public String deletePet(@RequestParam(name = "id", required = true) Long id,
                            @RequestParam(name = "ownerId") Long ownerId) {
        petService.deletePetById(id);
        return "redirect:/owner/details?id=" + ownerId;

    }

}
