package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 评论实体
 */
@Data
@Table(name = "appraise")
public class AppraiseEntity {
    @Id
    private Long id;
    private Long userId;
    private Long productId;
    private String content;
   // private String account;
    private Long createDate;
}
