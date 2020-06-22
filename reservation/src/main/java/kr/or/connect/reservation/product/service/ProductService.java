package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts(int id, int start, int limit);

    List<ProductDto> getProductsAll(int start, int limit);
}
