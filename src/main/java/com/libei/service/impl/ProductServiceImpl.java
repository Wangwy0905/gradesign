package com.libei.service.impl;

import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.SearchRequest;
import com.libei.entity.ProductEntity;
import com.libei.mapper.ProductMapper;
import com.libei.service.ProductService;
import com.libei.util.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
    public ProductDto query(Long categoryId, Long category2) {
//        List<ProductEntity> productEntityList = null;
//
//        if (categoryId == null || categoryId == 0 && category2 == null || category2 == 0) {
//            //后端  查所有产品
//            productEntityList = productMapper.query();
//        } else{
//            //前端 通过类别信息查产品
//            productEntityList = productMapper.queryByCategoryId(categoryId,category2);
//        }
//
//        List<ProductDetailDto> productDetailDtos = ListUtils.entityListToModelList(productEntityList, ProductDetailDto.class);
//        ProductDto productDto = new ProductDto();
//        productDto.setRows(productDetailDtos);
//        productDto.setTotal(productEntityList.size());
//
//       return productDto;
        return null;
    }

    @Override
    public List<ProductDetailDto> query() {

        List<ProductEntity> query = productMapper.query();
        return ListUtils.entityListToModelList(query,ProductDetailDto.class);
    }

    @Override
    public Boolean addProduct(ProductCommitRequest productCommitRequest, MultipartFile file, HttpServletRequest request) throws Exception {

        ProductEntity entity = new ProductEntity();
        entity.setProductName(productCommitRequest.getProductName());
        entity.setColor(productCommitRequest.getColor());
        entity.setPrice(productCommitRequest.getPrice());
        entity.setRepertory(productCommitRequest.getRepertory());
        entity.setCapacity(productCommitRequest.getCapacity());
        entity.setDescription(productCommitRequest.getDescription());
        entity.setCategoryId(productCommitRequest.getCategoryId());
        entity.setCategoryId2(productCommitRequest.getCategoryId2());
        entity.setSaleCount(0);
        String upload = upload(file, request);
        entity.setPicture(upload);
        entity.setStatus(true);
        entity.setBrand(productCommitRequest.getBrand().toString());
        entity.setCreateTime(System.currentTimeMillis());
        productMapper.insert(entity);

        return true;
    }

    @Override
    public String upload(MultipartFile file, HttpServletRequest request) throws Exception {

        if (file == null) {
            throw new Exception("图片文件为空,请检查");
        }

        String originalFilename = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("/") + "img\\" + originalFilename;

        File dest = new File(path);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    @Override
    public Boolean open(Long id, Boolean status) {
        ProductEntity productEntity = productMapper.selectByPrimaryKey(id);

        productEntity.setStatus(status);

        productMapper.updateByPrimaryKey(productEntity);

        return true;
    }

    @Override
    public List<ProductEntity>saleCount() {
        List<ProductEntity> productEntities = productMapper.querySaleCount();

        List<ProductEntity> list=new ArrayList<>();
        if (productEntities.size()>2){
            list.add(productEntities.get(0));
            list.add(productEntities.get(0));
            list.add(productEntities.get(0));

            return list;
        }else {
            return productEntities;
        }
    }


    @Override
    public Boolean delete(Long id) {
        productMapper.deleteByPrimaryKey(id);

        return true;
    }

    @Override
    public Boolean update(ProductCommitRequest request) {
        Long id = request.getId();
        ProductEntity entity = productMapper.selectByPrimaryKey(id);

        BeanUtils.copyProperties(request, entity);
        productMapper.updateByPrimaryKey(entity);

        return true;
    }

    @Override
    public ProductEntity queryOne(Long id) {
        return productMapper.selectByPrimaryKey(id);

    }

    @Override
    public ProductDto search(SearchRequest request) {
        String brand = request.getBrand().toString();
        String description = request.getDescription();
        String productName = request.getProductName();

        List<ProductEntity> productEntityList = productMapper.queryLike(brand, productName, description);
        List<ProductDetailDto> productDetailDtos = ListUtils.entityListToModelList(productEntityList, ProductDetailDto.class);
        ProductDto productDto = new ProductDto();
        productDto.setTotal(productEntityList.size());
        productDto.setRows(productDetailDtos);

        return productDto;

    }

    //TODO  激活待定

}
