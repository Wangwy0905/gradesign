package com.libei.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "FIRST_ID")
    private Long firstId;
    @Column(name = "CREATE_TIME")
    private Long createTime;
}
