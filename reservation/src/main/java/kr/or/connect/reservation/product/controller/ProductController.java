package kr.or.connect.reservation.product.controller;

import kr.or.connect.reservation.display.service.DisplayInfoImageService;
import kr.or.connect.reservation.display.service.DisplayInfoService;
import kr.or.connect.reservation.product.dto.ProductDto;
import kr.or.connect.reservation.product.service.ProductImageService;
import kr.or.connect.reservation.product.service.ProductPriceService;
import kr.or.connect.reservation.product.service.ProductService;
import kr.or.connect.reservation.reservation.service.ReservationUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ProductImageService productImageService;
    private ReservationUserCommentService reservationUserCommentService;
    private DisplayInfoService displayInfoService;
    private DisplayInfoImageService displayInfoImageService;

    @Autowired
    public ProductController(ProductService productService,
                             ProductPriceService productPriceService,
                             ProductImageService productImageService,
                             ReservationUserCommentService reservationUserCommentService,
                             DisplayInfoService displayInfoService,
                             DisplayInfoImageService displayInfoImageService) {
        this.productService = productService;
        this.productPriceService = productPriceService;
        this.productImageService = productImageService;
        this.reservationUserCommentService = reservationUserCommentService;
        this.displayInfoService = displayInfoService;
        this.displayInfoImageService = displayInfoImageService;
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
    public Map<String, Object> product(@PathVariable(name = "displayInfoId") int displayInfoId) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> comment = reservationUserCommentService.getReservationUserComments(displayInfoId);
        map.put("averageScore", comment.get("averageScore"));
        map.put("comments", comment.get("comments"));
        map.put("displayInfo", displayInfoService.getDisplayInfo(displayInfoId));
        map.put("productImages", productImageService.getProductImages(displayInfoId));
        map.put("displayInfoImage", displayInfoImageService.getDisplayInfoImage(displayInfoId));
        map.put("productPrices", productPriceService.getProductPrices(displayInfoId));
        return map;
    }
}
