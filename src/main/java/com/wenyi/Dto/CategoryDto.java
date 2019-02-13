package com.wenyi.Dto;

import com.wenyi.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategoryDto {
    @Id
    private  Integer total;
    private  List<Category> rows;
}
