package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dao.ProductImageDao;
import kr.or.connect.reservation.product.dto.ProductImageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private ProductImageDao productImageDao;

    public ProductImageServiceImpl(ProductImageDao productImageDao) {
        this.productImageDao = productImageDao;
    }

    @Override
    public List<ProductImageDto> getProductImages(int productId) {
        return productImageDao.selectByProductId(productId);
    }
}
