package com.sda.javagda34.pets.controllers;

import com.sda.javagda34.pets.model.Owner;
import com.sda.javagda34.pets.services.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
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
    @GetMapping("/delete")
    public String deleteOwner(@RequestParam (name="id",required = true) Long id){
        ownerService.deleteById(id);
        log.info("Owner id="+id+ "deleted");
        return "redirect:/owner/list";
    }
    @GetMapping("/details")
     public String getOwnerDetailsPage(Model model,@RequestParam(name="id",required = false) Long id){
        {
            Optional<Owner> ownerOptional = ownerService.findById(id);
            if (ownerOptional.isPresent()){
                model.addAttribute("owner",ownerOptional.get());
                return "ownerDetails";
            }else{
                return "redirect:/owner/list";

            }
        }
    }
    @GetMapping("/edit")
    public String updateOwner(Model model,@RequestParam (name ="id") Long id){
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if(optionalOwner.isPresent()){
Owner owner = optionalOwner.get();
        model.addAttribute("owner", owner);
        return "ownerForm";}
        else{
return "redirect:/owner/list";
        }
    }
}
