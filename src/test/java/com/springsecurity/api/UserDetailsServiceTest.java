package com.springsecurity.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = SpringSecurityApplication.class)
@ActiveProfiles("test")
public class UserDetailsServiceTest {

    @Autowired
    private UserDetailsService userDetailsService;

    //@Test
    public void getUserByName() {
        UserDetails user = userDetailsService.loadUserByUsername("toto");
        System.out.println(user.getUsername());
    }
}