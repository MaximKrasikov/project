package com.mai.projects.smarthome.controller.rest.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name= "device_measurement")
public class DeviceMeasurement {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "DEVICE_MEASUREMENT_SEQ_GENERATOR")
    @SequenceGenerator(name = "DEVICE_MEASUREMENT_SEQ_GENERATOR", sequenceName = "DEVICE_MEASUREMENT_SEQ", allocationSize = 10)
    private Long id;

    @NotNull
    @Column(name = "time_measurement")
    private LocalDateTime timeMeasurement;

    @NotNull
    @Column(name="user_device_id")
    private Long userDeviceId;

}
