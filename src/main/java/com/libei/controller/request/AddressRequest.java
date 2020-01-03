package com.libei.controller.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String name;
    private String phoneNum;
    private String province;
    private String city;
    private String detailAddress;
    private Long userId;
    private String remark;
    private Boolean isDefault;
}
