package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "address")
public class AddressEntity {
    @Id
    private Long id;
    private String province;
    private String city;
    private String detailAddress;
    private Long userId;
    private String remark;
    private Boolean isDefault;
    private LocalDateTime createDate;
}
