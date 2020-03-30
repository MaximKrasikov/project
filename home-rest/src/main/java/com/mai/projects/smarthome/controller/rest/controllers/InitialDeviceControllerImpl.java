package com.mai.projects.smarthome.controller.rest.controllers;

import com.mai.projects.smarthome.controller.rest.entities.User;
import com.mai.projects.smarthome.controller.rest.entities.UserDevice;
import com.mai.projects.smarthome.controller.rest.enums.ErrorEnum;
import com.mai.projects.smarthome.controller.rest.exception.ServerException;
import com.mai.projects.smarthome.controller.rest.model.request.InitialDeviceRequest;
import com.mai.projects.smarthome.controller.rest.model.request.RecordDataRequest;
import com.mai.projects.smarthome.controller.rest.repository.UserDeviceRepository;
import com.mai.projects.smarthome.controller.rest.repository.UserRepository;
import com.mai.projects.smarthome.controller.rest.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class InitialDeviceControllerImpl extends AbstractMainController implements InitialDeviceController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserDeviceRepository userDeviceRepository;

    public ResponseEntity recordInitialState(InitialDeviceRequest initialDeviceRequest, HttpServletRequest httpServletRequest) {
        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        String username = jwtTokenProvider.getUsername(token);
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ServerException(ErrorEnum.USER_BY_USERNAME_NOT_FOUND, List.of(username)));

      List<UserDevice> userDevices=  initialDeviceRequest.getDeviceInfos()
                .stream()
                .map(deviceInfo -> {
                    UserDevice userDevice = new UserDevice();
                    userDevice.setUserId(user.getId());
                    userDevice.setHomeId(deviceInfo.getHomeDeviceId());
                    userDevice.setDeviceId(deviceInfo.getDeviceTypeId());
                    return userDevice;
                }).collect(Collectors.toList());

        userDeviceRepository.saveAll(userDevices);

        return prepareResponseEntity();
    }

    public ResponseEntity recordData(RecordDataRequest recordDataRequest, HttpServletRequest httpServletRequest) {
        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        String username = jwtTokenProvider.getUsername(token);
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ServerException(ErrorEnum.USER_BY_USERNAME_NOT_FOUND, List.of(username)));

        return prepareResponseEntity();
    }
}
