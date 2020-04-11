package com.libei.Dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String detailAddress;
    private String  userName;
    private String remark;
    private Boolean isDefault;
    private String createDate;
}
