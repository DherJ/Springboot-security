package com.springsecurity.api.controller;

import com.springsecurity.api.models.ERole;
import com.springsecurity.api.models.Role;
import com.springsecurity.api.repository.IRoleRepository;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    IRoleRepository rolesRepository;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<Role> roles = rolesRepository.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Optional<Role>> findByName(@RequestParam(name="name") ERole role) {
        return ResponseEntity.ok(rolesRepository.findByName(role));
    }

    @PatchMapping("")
    public ResponseEntity<?> updateRole(@RequestBody Role role) {
        rolesRepository.save(role);
        return ResponseEntity.ok(new MessageResponse("Role updated successfully!"));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAll() {
        rolesRepository.deleteAll();
        return ResponseEntity.ok(new MessageResponse("Roles deleted successfully!"));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable(value="id") Long id) {
        rolesRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Role deleted successfully!"));
    }

}