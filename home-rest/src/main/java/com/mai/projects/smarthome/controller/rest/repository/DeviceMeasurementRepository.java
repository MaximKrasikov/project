package com.mai.projects.smarthome.controller.rest.repository;

import com.mai.projects.smarthome.controller.rest.entities.DeviceMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMeasurementRepository extends JpaRepository<DeviceMeasurement,Long> {

}
