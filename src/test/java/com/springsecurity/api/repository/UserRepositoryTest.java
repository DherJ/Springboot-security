package com.springsecurity.api.repository;

import com.springsecurity.api.models.User;
import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = ("com.springsecurity.api.repository"))
@EntityScan(basePackages = "com.springsecurity.api.models")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRepositoryTest {

    private static final int NB_INIT_USERS = 3;
    
    @Autowired
    private IUsersRepository repo;

    @Test
    public void getAllUsers_thenGetOk() {
        List<User> users = repo.findAll();
        assertFalse(users.isEmpty());
        assertEquals(NB_INIT_USERS, users.size());
    }

    @Test
    public void getUsersNameLike1_thenGetOk() {
        List<User> users = repo.findByContainingName("to");
        assertEquals(1, users.size());
        assertEquals("toto", users.get(0).getUsername());
    }

    @Test
    public void getUsersNameLike2_thenGetOk() {
        List<User> users = repo.findByContainingName("t");
        assertEquals(NB_INIT_USERS, users.size());
    }

    @Test
    public void deleteUser_thenGetOk() {
        List<User> users = repo.findAll();
        assertFalse(users.isEmpty());
        assertEquals(NB_INIT_USERS, users.size());

        repo.deleteById(1L);

        List<User> usersAfter = repo.findAll();
        assertFalse(usersAfter.isEmpty());
        assertEquals(NB_INIT_USERS - 1, usersAfter.size());
    }

    @Test
    public void saveUser_thenGetOk() {
        User newUser = new User();
        newUser.setEmail("a");
        newUser.setUsername("a");
        newUser.setPassword("a");

        List<User> users = repo.findAll();
        assertFalse(users.isEmpty());
        assertEquals(NB_INIT_USERS, users.size());

        repo.save(newUser);

        List<User> usersAfter = repo.findAll();
        assertFalse(usersAfter.isEmpty());
        assertEquals(NB_INIT_USERS + 1, usersAfter.size());
    }

    @Test
    public void updateUser_thenGetOk() {
        Optional<User> user = repo.findByUsername("toto");
        assertEquals("toto@toto.com", user.orElseThrow(AssertionFailedError::new).getEmail());
        user.get().setEmail("zzz@toto.com");

        repo.save(user.get());

        Optional<User> userSaved = repo.findByUsername("toto");
        assertEquals("zzz@toto.com", userSaved.orElseThrow(AssertionFailedError::new).getEmail());
    }
}