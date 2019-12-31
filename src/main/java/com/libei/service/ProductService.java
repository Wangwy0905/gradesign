package com.libei.service;

import com.libei.Dto.ProductDto;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.SearchRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductDto query(Long categoryId, Integer pageNum, Integer pageSize);

    Boolean addProduct(ProductCommitRequest request, MultipartFile file) throws Exception;

    Boolean delete(Long id);

    Boolean update(ProductCommitRequest request);

    ProductDto queryOne(Long id);

    ProductDto search(SearchRequest request);

    String upload(MultipartFile file) throws Exception;
}