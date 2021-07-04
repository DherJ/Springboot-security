package com.springsecurity.api.controller;

import com.springsecurity.api.models.User;
import com.springsecurity.api.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import payload.response.MessageResponse;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/admin/users")
public class AdminController {

    @Autowired
    IUsersRepository userRepository;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<List<User>> findByName(@RequestParam(name="name") String name) {
        return ResponseEntity.ok(userRepository.findByContainingName(name));
    }

    @PatchMapping("")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAll() {
        userRepository.deleteAll();
        return ResponseEntity.ok(new MessageResponse("Users deleted successfully!"));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
    }

}