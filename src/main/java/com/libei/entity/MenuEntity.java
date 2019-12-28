package com.libei.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "menu")
public class MenuEntity {
    @Id
    private Long id;
    private String title;
    private Boolean isShow;
    private Date createDateTime;
}
