package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<ProductDto> getProducts(int id, int start, int limit) {
        return productDao.selectById(id, start, limit);
    }
}
