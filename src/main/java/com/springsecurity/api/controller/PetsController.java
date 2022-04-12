package com.springsecurity.api.controller;

import com.springsecurity.api.models.Pet;
import com.springsecurity.api.repository.IPetsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import payload.response.MessageResponse;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/pets")
public class PetsController {

    @Autowired
    IPetsRepository petsRepository;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<Pet> pets = petsRepository.findAll();
        return ResponseEntity.ok(pets);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<List<Pet>> findByName(@RequestParam(name="name") String name) {
        return ResponseEntity.ok(petsRepository.findByContainingName(name));
    }

    @PatchMapping("")
    public ResponseEntity<?> updatePet(@RequestBody Pet pet) {
        petsRepository.save(pet);
        return ResponseEntity.ok(new MessageResponse("Pet updated successfully!"));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAll() {
        petsRepository.deleteAll();
        return ResponseEntity.ok(new MessageResponse("Users deleted successfully!"));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long id) {
        petsRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Pet deleted successfully!"));
    }

}