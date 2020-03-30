package com.mai.projects.smarthome.controller.rest.service;

import com.mai.projects.smarthome.controller.rest.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User register(User user);
    List<User> getAll();
    User findByUserName(String username);
    User findById(Long id);
    void delete(Long id);
}
