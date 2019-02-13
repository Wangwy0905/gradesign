package com.wenyi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="roleAndperm")
public class RoleAndperm {
    @Id
    private  Integer id;
    private  Integer rid;
    private  Integer pid;
}
