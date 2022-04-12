package com.springsecurity.api.repository;

import com.springsecurity.api.models.Pet;
import java.util.List;
import java.util.Optional;
import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = ("com.springsecurity.api.repository"))
@EntityScan(basePackages = "com.springsecurity.api.models")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PetsRepositoryTest {

    private static final int NB_INIT_PETS = 3;
    
    @Autowired
    private IPetsRepository repo;

    @Test
    public void getAllPets_thenGetOk() {
        List<Pet> roles = repo.findAll();
        assertFalse(roles.isEmpty());
        assertEquals(NB_INIT_PETS, roles.size());
    }

    @Test
    public void getPetByName_thenGetOk() {
        List<Pet> pets = repo.findByContainingName("Ne");
        assertEquals(1, pets.size());
        assertEquals("Neko", pets.get(0).getName());
    }

    @Test
    public void deleteUser_thenGetOk() {
        List<Pet> pets = repo.findAll();
        assertFalse(pets.isEmpty());
        assertEquals(NB_INIT_PETS, pets.size());

        repo.deleteById(1L);

        List<Pet> petsAfter = repo.findAll();
        assertFalse(petsAfter.isEmpty());
        assertEquals(NB_INIT_PETS - 1, petsAfter.size());
    }

    @Test
    public void saveUser_thenGetOk() {
        Pet newPet = new Pet();
        newPet.setName("a");
        newPet.setSpecies("Patée");
        newPet.setWeight(25);

        List<Pet> pets = repo.findAll();
        assertFalse(pets.isEmpty());
        assertEquals(NB_INIT_PETS, pets.size());

        repo.save(newPet);

        List<Pet> petsAfter = repo.findAll();
        assertFalse(petsAfter.isEmpty());
        assertEquals(NB_INIT_PETS + 1, petsAfter.size());
    }

    @Test
    public void updateUser_thenGetOk() {
        Optional<Pet> pet = repo.findByName("Neko");
        assertEquals("Neko", pet.orElseThrow(AssertionFailedError::new).getName());
        pet.get().setWeight(99);

        repo.save(pet.get());

        Optional<Pet> petSaved = repo.findByName("Neko");
        assertEquals("Neko", petSaved.orElseThrow(AssertionFailedError::new).getName());
        assertEquals(99, petSaved.orElseThrow(AssertionFailedError::new).getWeight());
    }
}