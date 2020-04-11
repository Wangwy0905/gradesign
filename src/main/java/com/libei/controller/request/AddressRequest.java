package com.libei.controller.request;

import lombok.Data;

@Data
public class AddressRequest {
    private Long id;
    private String province;
    private String city;
    private String detailAddress;
    private Long userId;
    private String gainName; //收货人姓名
    private String phoneNum;
    private String remark;
    private Boolean isDefault;
}
