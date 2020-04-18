package com.libei.controller;

import com.libei.Dto.CategoryDto;
import com.libei.Dto.CategoryResDto;
import com.libei.controller.request.CategoryRequest;
import com.libei.entity.CategoryEntity;
import com.libei.enums.BlandEnum;
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
    public Boolean add(@RequestBody CategoryRequest request){
        return categoryService.add(request);
    }

    @GetMapping("delete")
    @CrossOrigin
    public Boolean delete(@RequestParam Long id){
        return categoryService.delete(id);
    }

    @PostMapping("update")
    @CrossOrigin
    public Boolean update(@RequestBody CategoryRequest request){
        return categoryService.update(request);
    }

    @PostMapping("query-back")
    @CrossOrigin
    public List<CategoryResDto> queryBack(){
        return categoryService.queryBack();
    }

    @GetMapping("search")
    @CrossOrigin
    public List<CategoryResDto> queryBack(@RequestParam("brand")String brand){
        return categoryService.queryLike(brand);
    }

}
