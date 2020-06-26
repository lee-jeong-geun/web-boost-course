package kr.or.connect.reservation.product.controller;

import kr.or.connect.reservation.product.dto.ProductDto;
import kr.or.connect.reservation.category.service.CategoryService;
import kr.or.connect.reservation.product.service.ProductService;
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
    private static final int PRODUCT_LIMIT = 4;

    private CategoryService categoryService;
    private ProductService productService;

    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public Map<String, Object> products(@RequestParam(defaultValue = "0") int categoryId,
                                        @RequestParam(defaultValue = "0") int start) {
        int totalCount = 0;
        List<ProductDto> list = null;
        Map<String, Object> map = new HashMap<>();
        if (categoryId == 0) {
            totalCount = categoryService.getCategoryAllCount();
            list = productService.getProductsAll(start, PRODUCT_LIMIT);
        } else {
            totalCount = categoryService.getCategoryCount(categoryId);
            list = productService.getProducts(categoryId, start, PRODUCT_LIMIT);
        }

        map.put("totalCount", totalCount);
        map.put("items", list);
        return map;
    }
}
