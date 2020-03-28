package com.libei.mapper;

import com.libei.entity.ProductEntity;
import com.libei.enums.BlandEnum;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductMapper extends Mapper<ProductEntity> {
    List<ProductEntity> queryByCategoryId(@Param("categoryId") Long categoryId, @Param("categoryId2") Long categoryId2, @Param(value = "pageSize") Integer pageSize, @Param(value = "pageNum") Integer pageNum);
    List<ProductEntity> query(@Param(value = "pageSize") Integer pageSize, @Param(value = "pageNum") Integer pageNum);

    List<ProductEntity> queryLike(@Param(value = "brand")String brand, @Param(value = "productName")String productName, @Param(value = "description")String description, @Param(value = "pageSize") Integer pageSize, @Param(value = "pageNum") Integer pageNum);

    void delete(Long categoryId);
}
