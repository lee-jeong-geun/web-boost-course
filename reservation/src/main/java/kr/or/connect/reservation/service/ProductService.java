package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts(int id, int start, int limit);
}
