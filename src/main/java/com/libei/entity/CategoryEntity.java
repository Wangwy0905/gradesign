package com.libei.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
    @Column(name = "TYPE")//分类级别
    private Long type;
    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime createDateTime;
}
