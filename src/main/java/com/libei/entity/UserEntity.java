package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
@Data
public class UserEntity {
    @Id
    private Long id;
    private String account;
    private String password;
    private String salt;
}
