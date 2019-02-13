package com.wenyi.service;

import com.wenyi.Dto.CategoryDto;
import com.wenyi.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface CategoryService {
    public CategoryDto queryAllByPage(int page,int rows);
    public void querySecond(Integer pid1, Integer pid2, Integer pid3, Integer pid4, HttpSession session);
}
