package com.springsecurity.api.repository;

import java.util.Optional;

import com.springsecurity.api.models.ERole;
import com.springsecurity.api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
