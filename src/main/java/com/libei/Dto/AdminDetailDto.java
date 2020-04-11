package com.libei.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminDetailDto {
    private  Integer id;
    private  String  username;
    private  String  password;
    private LocalDateTime createDate;
}
