package com.mai.projects.smarthome.controller.rest.repository;

import com.mai.projects.smarthome.controller.rest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);

}
