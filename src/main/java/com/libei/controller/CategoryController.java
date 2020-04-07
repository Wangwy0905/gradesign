package com.libei.controller;

import com.libei.Dto.CategoryDto;
import com.libei.Dto.CategoryResDto;
import com.libei.controller.request.CategoryRequest;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.CategoryEntity;
import com.libei.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @auth li bei
 * @date 2019.12.30
 * 产品类别相关接口
 */
@RestController
@RequestMapping("category")
@Api(value = "类别相关Api接口", description = "类别相关Api接口")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @CrossOrigin
    @GetMapping("query-first")
    public List<CategoryDto> queryFirst() {
        List<CategoryDto> categoryDtoList = categoryService.queryFirst();

        return categoryDtoList;
    }
    @GetMapping("query-second")
    @CrossOrigin
    public List<CategoryEntity> querySecond(@RequestParam Long firstId) {

        List<CategoryEntity> categoryDtoList = categoryService.querySecond(firstId);
        return categoryDtoList;

    }


    @PostMapping("add")
    @CrossOrigin
    public Boolean add(@RequestBody @Valid @NotNull CategoryRequest request){
        return categoryService.add(request);
    }

    @GetMapping("delete")
    @CrossOrigin
    public Boolean delete(@RequestParam Long id){
        return categoryService.delete(id);
    }

    @PostMapping("update")
    @CrossOrigin
    public Boolean update(@RequestParam CategoryRequest request){
        return categoryService.update(request);
    }

    @PostMapping("query-back")
    @CrossOrigin
    public List<CategoryEntity> queryBack(){
        return categoryService.queryBack();
    }

}
