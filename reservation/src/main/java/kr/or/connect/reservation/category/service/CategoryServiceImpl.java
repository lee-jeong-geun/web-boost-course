package kr.or.connect.reservation.category.service;

import kr.or.connect.reservation.category.dao.CategoryDao;
import kr.or.connect.reservation.category.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryDao.selectAll();
    }
}
