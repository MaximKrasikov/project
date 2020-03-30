package com.mai.projects.smarthome.controller.rest.repository;

import com.mai.projects.smarthome.controller.rest.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
