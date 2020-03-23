package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class AdminDetailDto {
    private  Integer id;
    private  String  username;
    private  String  password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
}
