package com.mai.projects.smarthome.controller.rest.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name= "user_device")
public class UserDevice {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "USER_DEVICE_SEQ_GENERATOR")
    @SequenceGenerator(name = "USER_DEVICE_SEQ_GENERATOR", sequenceName = "USER_DEVICE_SEQ", allocationSize = 10)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "home_id")
    private Long homeId;

    @Column(name = "device_id")
    private Long deviceId;

}
