package kr.or.connect.reservation.category.service;

import kr.or.connect.reservation.category.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    int getCategoryCount(int id);

    int getCategoryAllCount();
}
