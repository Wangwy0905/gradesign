package com.wenyi.service;

import com.wenyi.Dto.CategoryDto;
import com.wenyi.entity.Category;
import com.wenyi.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public CategoryDto queryAllByPage(int page, int rows) {
        List<Category> categories = categoryMapper.queryAllByPage(page, rows);
        Integer integer = categoryMapper.totalNum();
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setTotal(integer);
        categoryDto.setRows(categories);

        return  categoryDto;
    }

    //查询二级标题
    @Override
    public HashMap<String, List<Category>> querySecond(Integer pid1, Integer pid2, Integer pid3, Integer pid4) {
        HashMap<String, List<Category>> map = new HashMap<>();
        List<Category> categories1 = categoryMapper.querySecond(pid1);
        List<Category> categories2 = categoryMapper.querySecond(pid2);
        List<Category> categories3 = categoryMapper.querySecond(pid3);
        List<Category> categories4 = categoryMapper.querySecond(pid4);

        map.put("list1",categories1);
        map.put("list2",categories2);
        map.put("list3",categories3);
        map.put("list4",categories4);

        return map;

    }

    @Override
    public List<Category> queryAll() {
        //前台分类
            List<Category> categories = categoryMapper.queryAll();

            return  categories;

    }
}
