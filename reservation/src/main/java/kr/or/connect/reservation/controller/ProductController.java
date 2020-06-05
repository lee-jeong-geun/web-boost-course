package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.ProductDto;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    private CategoryService categoryService;
    private ProductService productService;

    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public Map<String, Object> products(@RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId,
                                        @RequestParam(value = "start", required = false, defaultValue = "0") int start) {
        int totalCount = 0;
        List<ProductDto> list = null;
        Map<String, Object> map = new HashMap<>();
        if (categoryId == 0) {
            totalCount = categoryService.getCategoryAllCount();
            list = productService.getProductsAll(start, 4);
        } else {
            totalCount = categoryService.getCategoryCount(categoryId);
            list = productService.getProducts(categoryId, start, 4);
        }
        if(list != null) {
            for(ProductDto productDto : list) {
                productDto.setProductImageUrl("img/" + productDto.getProductImageUrl());
            }
        }

        map.put("totalCount", totalCount);
        map.put("items", list);
        return map;
    }
}
