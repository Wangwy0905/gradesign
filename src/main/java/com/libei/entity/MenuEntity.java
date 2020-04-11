package com.libei.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "menu")
public class MenuEntity {
    @Id
    private Long id;
    private String title;
    private Boolean isShow;
    private LocalDateTime createDate;
}
