package com.libei.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "banner")
public class BannerEntity {
    @Id
    private Long id;
    private String picture;
    private String title;
    private LocalDateTime createTime;
    private Boolean status;
}
