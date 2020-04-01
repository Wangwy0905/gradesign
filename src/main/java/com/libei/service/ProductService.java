package com.libei.service;

import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.SearchRequest;
import com.libei.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductDetailDto> query();
    ProductDto query(Long categoryId,Long category2);

    Boolean addProduct(ProductCommitRequest request, MultipartFile file) throws Exception;

    Boolean delete(Long id);

    Boolean update(ProductCommitRequest request);

    ProductEntity queryOne(Long id);

    ProductDto search(SearchRequest request);

    String upload(MultipartFile file) throws Exception;

    Boolean open(Long id,Boolean status);
}
