package com.libei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="adminAndrole")
public class AdminAndrole {
    @Id
    private  Integer id;
    private  Integer aid;
    private Integer rid;
}
