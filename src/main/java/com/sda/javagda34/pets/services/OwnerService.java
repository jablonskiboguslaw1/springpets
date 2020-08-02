package com.sda.javagda34.pets.services;

import com.sda.javagda34.pets.model.Owner;
import com.sda.javagda34.pets.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
