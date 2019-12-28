package com.libei.controller;

import com.libei.Dto.CategoryDto;
import com.libei.entity.CategoryEntity;
import com.libei.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("category")
@Api(value = "别相关Api接口", description = "类别相关Api接口")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @CrossOrigin
    @GetMapping("query-first")
    public List<CategoryDto> queryFirst() {
        List<CategoryDto> categoryDtoList = categoryService.queryFirst();

        return categoryDtoList;
    }

    @GetMapping("query-Second")
    @CrossOrigin
    public List<CategoryDto> querySecond(@RequestBody @Valid @NotNull Long firstId) {

        List<CategoryDto> categoryDtoList = categoryService.querySecond(firstId);
        return categoryDtoList;

    }


//    @GetMapping("queryAll")
//    public List<CategoryEntity> queryAll() {
//        List<CategoryEntity> categories = categoryService.queryAll();
//
//        return categories;
//    }
}
