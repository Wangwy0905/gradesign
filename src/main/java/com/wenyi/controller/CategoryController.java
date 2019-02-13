package com.wenyi.controller;

import com.wenyi.Dto.CategoryDto;
import com.wenyi.entity.Category;
import com.wenyi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("queryAllByPage")
    public CategoryDto queryAllByPage(int page,int rows){
        CategoryDto categoryDto = categoryService.queryAllByPage(page, rows);

        return categoryDto;
    }

    //查询二级标题
    @RequestMapping("querySecond")

    public HashMap<String, List<Category>> querySecond(Integer pid1, Integer pid2, Integer pid3, Integer pid4){

        HashMap<String, List<Category>> map = categoryService.querySecond(pid1, pid2, pid3, pid4);
        return map;

    }
}
