package com.springsecurity.api.repository;

import com.springsecurity.api.models.Pet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetsRepository extends JpaRepository<Pet, Long> {
    
    Optional<Pet> findByName(String username);
    
    @Query("SELECT p FROM Pet p WHERE p.name like %:name%")
    List<Pet> findByContainingName(@Param("name") String name);
}