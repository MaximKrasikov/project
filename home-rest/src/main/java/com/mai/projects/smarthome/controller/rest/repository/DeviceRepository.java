package com.mai.projects.smarthome.controller.rest.repository;

import com.mai.projects.smarthome.controller.rest.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
        void deleteDeviceById(Long id);
}