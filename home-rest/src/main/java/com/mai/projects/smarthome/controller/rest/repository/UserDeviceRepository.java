package com.mai.projects.smarthome.controller.rest.repository;

import com.mai.projects.smarthome.controller.rest.entities.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeviceRepository extends JpaRepository<UserDevice,Long> {
}
