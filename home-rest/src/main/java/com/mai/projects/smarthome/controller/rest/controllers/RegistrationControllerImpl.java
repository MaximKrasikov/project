package com.mai.projects.smarthome.controller.rest.controllers;

import com.mai.projects.smarthome.controller.rest.entities.Role;
import com.mai.projects.smarthome.controller.rest.entities.Status;
import com.mai.projects.smarthome.controller.rest.entities.User;
import com.mai.projects.smarthome.controller.rest.enums.RoleEnum;
import com.mai.projects.smarthome.controller.rest.exception.ServerException;
import com.mai.projects.smarthome.controller.rest.model.request.RegistrationRequest;
import com.mai.projects.smarthome.controller.rest.repository.RoleRepository;
import com.mai.projects.smarthome.controller.rest.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.mai.projects.smarthome.controller.rest.enums.ErrorEnum.USERNAME_OR_EMAIL_ARE_ALWAYS_EXIST;

@AllArgsConstructor
@RestController
@Slf4j
public class RegistrationControllerImpl extends AbstractMainController implements RegistrationController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;

    @Override
    public ResponseEntity registration(@Valid RegistrationRequest registrationRequest) {
        Role userRole = roleRepository.findByName(RoleEnum.USER.getName()).orElse(null);
        User user =  new User();

        user.setUserName(registrationRequest.getUserName());
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(encoder.encode(registrationRequest.getPassword()));
        user.setRoles(List.of(userRole));
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setStatus(Status.ACTIVE);
        try{
            userRepository.save(user);
        }catch(DataIntegrityViolationException ex){
            throw new ServerException(USERNAME_OR_EMAIL_ARE_ALWAYS_EXIST, List.of());
        }
        return prepareResponseEntity();
    }
}
