package com.mai.projects.smarthome.controller.rest.controllers;

import com.mai.projects.smarthome.controller.rest.entities.Device;
import com.mai.projects.smarthome.controller.rest.model.request.AddDeviceTypeRequest;
import com.mai.projects.smarthome.controller.rest.model.request.UpdateDeviceTypeRequest;
import com.mai.projects.smarthome.controller.rest.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DeviceTypeControllerImpl extends AbstractMainController implements DeviceTypeController {

    private final DeviceRepository deviceRepository;

    @Override
    public ResponseEntity addDeviceType(AddDeviceTypeRequest addDeviceTypeRequest) {
        Device device = new Device();
        device.setUnitName(addDeviceTypeRequest.getUnitName());
        device.setTitle(addDeviceTypeRequest.getTitle());
        deviceRepository.save(device);

        return prepareResponseEntity();
    }

    @Override
    public ResponseEntity updateDeviceType(UpdateDeviceTypeRequest updateDeviceTypeRequest) {
        Device device= new Device();
        device.setTitle(updateDeviceTypeRequest.getTitle());
        device.setUnitName(updateDeviceTypeRequest.getUnitName());
        device.setId(updateDeviceTypeRequest.getId());
        deviceRepository.save(device);
        return prepareResponseEntity();
    }

    @Override
    public ResponseEntity deleteDeviceType(Long deviceTypeId) {
        deviceRepository.deleteDeviceById(deviceTypeId);
        return prepareResponseEntity();
    }

    @Override
    public ResponseEntity fetchDeviceType(Long deviceTypeId) {
        deviceRepository.getOne(deviceTypeId);
        return prepareResponseEntity();
    }
}
