package com.libei.controller;

import com.libei.Dto.ProductDto;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.ProductQueryRequest;
import com.libei.controller.request.SearchRequest;
import com.libei.entity.ProductEntity;
import com.libei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @Author li bei
 * @date 2019.12.28
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @CrossOrigin
    @RequestMapping("query")
    public ProductDto query(@RequestBody ProductQueryRequest request) {

        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();
        Long categoryId = request.getCategoryId();
        ProductDto computerDto = productService.query(categoryId,pageNum, pageSize);
        return computerDto;
    }


    @CrossOrigin
    @PostMapping("add-product")
    public Boolean addPhone(@RequestBody ProductCommitRequest request, MultipartFile file) throws Exception {
        return productService.addProduct(request, file);
    }

    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestParam Long id) throws IOException {
        return productService.delete(id);
    }

    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody ProductCommitRequest request) throws IOException {
        return productService.update(request);
    }

    @CrossOrigin
    @PostMapping("query-one")
    public ProductEntity queryOne(@RequestBody @Valid @NotNull Long id) throws IOException {
        return productService.queryOne(id);
    }

    @CrossOrigin
    @PostMapping("search")
    public ProductDto search(@RequestBody SearchRequest request) throws IOException {

        return productService.search(request);
    }

}
