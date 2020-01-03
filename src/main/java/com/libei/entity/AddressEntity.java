package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class AddressEntity {
    @Id
    private Long id;
    private String name;
    private String phoneNum;
    private String province;
    private String city;
    private String detailAddress;
    private Long userId;
    private String remark;
    private Boolean isDefault;
}
