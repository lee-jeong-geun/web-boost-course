package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dao.ProductImageDao;
import kr.or.connect.reservation.product.dto.ProductImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private ProductImageDao productImageDao;

    @Autowired
    public ProductImageServiceImpl(ProductImageDao productImageDao) {
        this.productImageDao = productImageDao;
    }

    @Override
    public List<ProductImageDto> getProductImages(int displayInfoId) {
        return productImageDao.selectByDisplayInfoId(displayInfoId);
    }
}
