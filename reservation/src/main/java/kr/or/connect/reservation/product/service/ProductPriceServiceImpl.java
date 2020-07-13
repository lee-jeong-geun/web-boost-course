package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dao.ProductPriceDao;
import kr.or.connect.reservation.product.dto.ProductPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    private ProductPriceDao productPriceDao;

    @Autowired
    public ProductPriceServiceImpl(ProductPriceDao productPriceDao) {
        this.productPriceDao = productPriceDao;
    }

    @Override
    public List<ProductPriceDto> getProductPrices(int displayInfoId) {
        return productPriceDao.selectByProductId(displayInfoId);
    }
}
