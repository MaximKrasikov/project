package com.mai.projects.smarthome.controller.rest.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name= "device")
public class Device {
   @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "DEVICE_SEQ_GENERATOR")
    @SequenceGenerator(name = "DEVICE_SEQ_GENERATOR", sequenceName = "DEVICE_SEQ", allocationSize = 10)
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "unit_name")
    private String unitName;
}
