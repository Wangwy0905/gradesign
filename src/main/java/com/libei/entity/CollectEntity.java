package com.libei.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "collect")
public class CollectEntity {
    @Id
    private Long id;
    private Long userId;
    private Long productId;
    private LocalDateTime createDate;

}
