package com.springsecurity.api.repository;

import com.springsecurity.api.models.ERole;
import com.springsecurity.api.models.Role;
import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = ("com.springsecurity.api.repository"))
@EntityScan(basePackages = "com.springsecurity.api.models")
public class RoleRepositoryTest {

    @Autowired
    private IRoleRepository repo;

    @Test
    public void getAllRoles_thenGetOk() {
        List<Role> roles = repo.findAll();
        assertFalse(roles.isEmpty());
        assertEquals(3, roles.size());
    }

    @Test
    public void getRolesByName_thenGetOk() {
        Role userRole = new Role();
        userRole.setId(1);
        userRole.setName(ERole.USER);
        Optional<Role> opt = repo.findByName(ERole.USER);
        assertEquals(userRole.getName(), opt.orElseThrow(AssertionFailedError::new).getName());
    }
}