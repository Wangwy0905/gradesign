package com.libei.service.impl;

import com.libei.Dto.ProductDto;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.SearchRequest;
import com.libei.entity.ProductEntity;
import com.libei.mapper.ProductMapper;
import com.libei.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author li bei
 * @date 2019.12.30
 * @description 产品相关接口实现
 */

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDto query(Long categoryId, Integer pageNum, Integer pageSize) {
        List<ProductEntity> productEntityList = null;

        if (categoryId == null) {
            //后端  查所有产品
            productEntityList = productMapper.query(pageNum, pageSize);
        } else if (categoryId != null) {
            //前端 通过类别信息查产品
            productEntityList = productMapper.queryByCategoryId(categoryId, pageNum, pageSize);
        }
        ProductDto productDto = new ProductDto();
        productDto.setRows(productEntityList);
        productDto.setTotal(productEntityList.size());

        return productDto;
    }

    @Override
    public Boolean addProduct(ProductCommitRequest request, MultipartFile file) throws Exception {

        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(entity, request);

        entity.setPicture(this.upload(file));

        productMapper.insert(entity);

        return true;
    }
    @Override
    public String upload(MultipartFile file) throws Exception {

        if (file == null) {
            throw new Exception("图片文件为空,请检查");
        }

        String originalFilename = file.getOriginalFilename();
        String path = "D:/upload/" + originalFilename;

        File dest = new File(path);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return originalFilename;
    }


    @Override
    public Boolean delete(Long id) {
        ProductEntity entity = productMapper.selectByPrimaryKey(id);
        entity.setStatus(false);
        productMapper.insert(entity);

        return true;
    }

    @Override
    public Boolean update(ProductCommitRequest request) {
        Long id = request.getId();
        ProductEntity entity = productMapper.selectByPrimaryKey(id);

        BeanUtils.copyProperties(entity, request);
        productMapper.insert(entity);

        return true;
    }

    @Override
    public ProductDto queryOne(Long id) {

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productDto, productMapper.selectByPrimaryKey(id));

        return productDto;
    }

    @Override
    public ProductDto search(SearchRequest request) {
        String brand = request.getBrand().toString();
        String description = request.getDescription();
        String productName = request.getProductName();
        int pageSize = request.getPageSize();
        int pageNum = request.getPageNum();

        List<ProductEntity> productEntityList = productMapper.queryLike(brand, productName, description, pageSize, pageNum);

        ProductDto productDto = new ProductDto();
        productDto.setTotal(productEntityList.size());
        productDto.setRows(productEntityList);

        return productDto;

    }

    //TODO  激活待定
}