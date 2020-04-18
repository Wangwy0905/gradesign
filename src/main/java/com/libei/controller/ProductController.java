package com.libei.controller;

import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.OpenRequest;
import com.libei.controller.request.ProductCommitRequest;
import com.libei.controller.request.SearchRequest;
import com.libei.entity.ProductEntity;
import com.libei.enums.BlandEnum;
import com.libei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

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
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public List<ProductDetailDto> query() {

        return productService.query();

    }
//    @CrossOrigin
//    @RequestMapping(value = "query", method = RequestMethod.POST)
//    public ProductDto query(@RequestBody ProductQueryRequest request) {
//
//        Long categoryId = request.getCategoryId();
//        Long categoryId2 = request.getCategoryId2();
//        ProductDto computerDto = productService.query(categoryId,categoryId2);
//        return computerDto;
//    }

    //对象与文件上传  暂未想到刚好的方法  暂定这样  待优化
    @CrossOrigin
    @PostMapping("add-product")
    public Boolean addPhone(@RequestParam("productName") String productName,
                            @RequestParam("color") String color,
                            @RequestParam("price") Double price,
                            @RequestParam("repertory") Integer repertory,
                            @RequestParam("capacity") String capacity,
                            @RequestParam("description") String description,
                            @RequestParam("brand") BlandEnum brand,
                            @RequestParam("file") MultipartFile file,
                            @RequestParam("categoryId") Long categoryId,
                            @RequestParam("categoryId2") Long categoryId2,
                            HttpServletRequest request) throws Exception {
        ProductCommitRequest productCommitRequest = new ProductCommitRequest();
        productCommitRequest.setProductName(productName);
        productCommitRequest.setColor(color);
        productCommitRequest.setPrice(price);
        productCommitRequest.setCapacity(capacity);
        productCommitRequest.setRepertory(repertory);
        productCommitRequest.setDescription(description);
        productCommitRequest.setBrand(brand);
        productCommitRequest.setCategoryId(categoryId);
        productCommitRequest.setCategoryId2(categoryId2);

        return productService.addProduct(productCommitRequest,file,request);
    }

    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam Long id) throws IOException {
        return productService.delete(id);
    }

    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody ProductCommitRequest request) throws IOException {
        return productService.update(request);
    }

    @CrossOrigin
    @GetMapping("query-one")
    public ProductEntity queryOne(@RequestParam @Valid @NotNull Long id) throws IOException {
        return productService.queryOne(id);
    }

    //TODO 前台搜索
    @CrossOrigin
    @PostMapping("search")
    public  List<ProductDetailDto> search(@RequestBody SearchRequest request) throws IOException {

        return productService.search(request);
    }

    @CrossOrigin
    @GetMapping("search-back")
    public List<ProductDetailDto> searchBack(@RequestParam("productName") String productName) throws IOException {

        return productService.searchBack(productName);
    }


    //激活
    @CrossOrigin
    @PostMapping("open")
    public Boolean open(@RequestBody @Valid @NotNull OpenRequest openRequest){
        Long id = openRequest.getId();
        Boolean status = openRequest.getStatus();
        return productService.open(id,status);
    }

    @CrossOrigin
    @GetMapping("sale-count")
    public List<ProductEntity> saleCount(){
        return productService.saleCount();
    }

}
