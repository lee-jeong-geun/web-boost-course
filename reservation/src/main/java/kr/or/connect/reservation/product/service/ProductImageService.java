package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dto.ProductImageDto;

import java.util.List;

public interface ProductImageService {
    List<ProductImageDto> getProductImages(int productId);
}
