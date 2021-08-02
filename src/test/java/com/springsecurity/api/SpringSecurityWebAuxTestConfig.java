package com.springsecurity.api;

import com.springsecurity.api.models.ERole;
import com.springsecurity.api.security.model.UserDetailsImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.Collections;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {

        UserDetails basicUser = new UserDetailsImpl(1L, "Basic User", "user@company.com", "password", Collections.singletonList(
                new SimpleGrantedAuthority(ERole.USER.name())
        ));
        UserDetails moderatorUser = new UserDetailsImpl(2L, "Moderator User", "moderator@company.com", "password", Collections.singletonList(
                new SimpleGrantedAuthority(ERole.MODERATOR.name())
        ));
        UserDetails managerUser = new UserDetailsImpl(2L, "Manager User", "manager@company.com", "password", Collections.singletonList(
                new SimpleGrantedAuthority(ERole.ADMIN.name())
        ));
        
        return new InMemoryUserDetailsManager(Arrays.asList( basicUser, moderatorUser, managerUser ));
    }
}