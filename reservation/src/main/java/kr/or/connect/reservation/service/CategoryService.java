package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
    int getCategoryCount(int id);
}
