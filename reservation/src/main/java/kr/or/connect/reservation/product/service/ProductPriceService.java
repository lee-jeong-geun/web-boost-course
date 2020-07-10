package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dto.ProductPriceDto;

import java.util.List;

public interface ProductPriceService {
    List<ProductPriceDto> getProductPrices(int productId);
}
