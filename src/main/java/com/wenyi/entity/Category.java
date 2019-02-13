package com.wenyi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    private  Integer id;
    private  String categoryName;
    private  Integer pid;
    private  List<Category> children;
    private  List<Category> categoryList;
}
