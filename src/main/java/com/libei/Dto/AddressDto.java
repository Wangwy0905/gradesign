package com.libei.Dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String detailAddress;
    private String province;
    private String city;
    private String  gainName;
    private String phoneNum;
    private String remark;
    private Boolean isDefault;
    private Long createDate;
}
