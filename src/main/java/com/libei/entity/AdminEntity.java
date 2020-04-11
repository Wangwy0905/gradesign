package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "admin")
public class AdminEntity {
    @Id
    private Long id;
    private String account;
    private String password;
    private LocalDateTime createDate;
}
