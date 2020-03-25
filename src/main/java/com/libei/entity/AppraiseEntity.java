package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "appraise")
public class AppraiseEntity {
    @Id
    private Long id;
    private Long userId;
    private Long orderId;
    private String content;
    private Date createDate;
}
