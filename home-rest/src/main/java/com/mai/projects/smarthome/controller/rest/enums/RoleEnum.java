package com.mai.projects.smarthome.controller.rest.enums;


import lombok.Getter;

@Getter
public enum RoleEnum {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

   private  String name;

    RoleEnum(String name) {
        this.name = name;
    }
}
