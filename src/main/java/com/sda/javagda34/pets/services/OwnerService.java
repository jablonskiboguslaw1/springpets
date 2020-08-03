package com.sda.javagda34.pets.services;

import com.sda.javagda34.pets.model.Owner;
import com.sda.javagda34.pets.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public void update(Owner owner) {
        ownerRepository.save(owner);


    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public void deleteById(Long id) {

        ownerRepository.deleteById(id);
    }

    public Optional<Owner> findById(Long id) {
        return  ownerRepository.findById(id);
    }
}
