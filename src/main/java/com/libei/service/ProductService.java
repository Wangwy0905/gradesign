package com.libei.service;

import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.SearchRequest;
import com.libei.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {

    List<ProductDetailDto> query();
    ProductDto query(Long categoryId,Long category2);

    Boolean addProduct(ProductCommitRequest productCommitRequest,MultipartFile file,HttpServletRequest request) throws Exception;

    Boolean delete(Long id);

    Boolean update(ProductCommitRequest request);

    ProductEntity queryOne(Long id);

    List<ProductDetailDto> search(SearchRequest request);
    List<ProductDetailDto> searchBack(String  productName);

    String upload(MultipartFile file,HttpServletRequest request) throws Exception;

    Boolean open(Long id,Boolean status);

    List<ProductEntity> saleCount();
}
