package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class UserEntity {
    @Id
    private Long id;
    private String account; //手机号
    private String name;
    private String password;
    private String idNum;
    private Boolean sex;
    private String email;
    private String status;
    private String salt;
    private Date createDateTime;
}
