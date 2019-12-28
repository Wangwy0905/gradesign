package com.libei.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class   MenuDto {

    private Integer id;
    private String title;
    //private  Integer parentId;
    private Boolean isShow;
    private LocalDateTime createDateTime;
}

