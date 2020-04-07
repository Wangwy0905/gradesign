package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AddressDto {
    private Long id;
    private String detailAddress;
    private String  userName;
    private String remark;
    private Boolean isDefault;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;
}
