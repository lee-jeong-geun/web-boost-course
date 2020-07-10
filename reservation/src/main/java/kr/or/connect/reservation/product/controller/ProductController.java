package kr.or.connect.reservation.product.controller;

import kr.or.connect.reservation.product.dto.ProductDto;
import kr.or.connect.reservation.product.service.ProductPriceService;
import kr.or.connect.reservation.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    private static final int PRODUCT_LIMIT = 4;

    private ProductService productService;
    private ProductPriceService productPriceService;

    public ProductController(ProductService productService, ProductPriceService productPriceService) {
        this.productService = productService;
        this.productPriceService = productPriceService;
    }

    @GetMapping
    public Map<String, Object> products(@RequestParam(defaultValue = "0") int categoryId,
                                        @RequestParam(defaultValue = "0") int start) {
        int totalCount = 0;
        List<ProductDto> list = null;
        Map<String, Object> map = new HashMap<>();
        if (categoryId == 0) {
            totalCount = productService.getProductAllCount();
            list = productService.getProductsAll(start, PRODUCT_LIMIT);
        } else {
            totalCount = productService.getProductCount(categoryId);
            list = productService.getProducts(categoryId, start, PRODUCT_LIMIT);
        }

        map.put("totalCount", totalCount);
        map.put("items", list);
        return map;
    }

    @GetMapping
    @RequestMapping(path = "/{displayInfoId}")
    public Map<String, Object> product(@PathVariable(name = "displayInfoId") int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("productPrices", productPriceService.getProductPrices(id));
        return map;
    }
}
