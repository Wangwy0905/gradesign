package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MenuDto {

    private Long id;
    private String title;
    //private  Integer parentId;
    private Boolean isShow;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
}

