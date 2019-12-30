package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Admin {
    @Id
    private  Integer id;
    private  String  username;
    private  String  password;
}
