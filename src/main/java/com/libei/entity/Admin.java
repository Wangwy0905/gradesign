package com.libei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    private  Integer id;
    private  String  username;
    private  String  password;
    private  String salt;
    private  Integer grade;
}
