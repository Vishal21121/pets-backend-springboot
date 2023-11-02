package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@RestController

@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping(path = "/addPet")
    public @ResponseBody Pets addPet(@RequestBody Pets pet){
        petRepository.save(pet);
        return petRepository.findByName(pet.getName());
    }

}
