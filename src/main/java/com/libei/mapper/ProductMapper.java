package com.libei.mapper;

import com.libei.entity.ProductEntity;
import com.libei.enums.BlandEnum;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductMapper extends Mapper<ProductEntity> {
    List<ProductEntity> queryByCategoryId(@Param("categoryId") Long categoryId, @Param("categoryId2") Long categoryId2);
    List<ProductEntity> query();

    List<ProductEntity> queryLike(@Param(value = "brand")String brand, @Param(value = "productName")String productName, @Param(value = "description")String description);

    void deleteByCategory(Long categoryId2);

    ProductEntity queryFront(Long productId);


    Integer count(Long userId);

    List<ProductEntity> queryLikeBack(String productName);

    List<ProductEntity> querySaleCount();

    List<ProductEntity> selectByCategory(Long categoryId2);


    //Boolean addSale();
}
