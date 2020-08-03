package com.sda.javagda34.pets.services;

import com.sda.javagda34.pets.model.Pet;
import com.sda.javagda34.pets.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PetService {
    private final PetRepository petRepository;


    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);

    }

    public void update(Pet pet) {
        petRepository.save(pet);
    }
}
