package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class AdminEntity {
    @Id
    private  Integer id;
    private  String  username;
    private  String  password;
}
