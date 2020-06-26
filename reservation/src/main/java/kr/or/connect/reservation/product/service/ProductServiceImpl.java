package kr.or.connect.reservation.product.service;

import kr.or.connect.reservation.product.dao.ProductDao;
import kr.or.connect.reservation.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<ProductDto> getProducts(int id, int start, int limit) {
        return productDao.selectById(id, start, limit);
    }

    @Override
    public List<ProductDto> getProductsAll(int start, int limit) {
        return productDao.selectAll(start, limit);
    }

    @Override
    public int getProductCount(int id) {
        return productDao.selectCount(id);
    }

    @Override
    public int getProductAllCount() {
        return productDao.selectAllCount();
    }
}
