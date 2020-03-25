package com.libei.Dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String province;
    private String city;
    private String detailAddress;
    private Long userId;
    private String remark;
    private Boolean isDefault;
}
