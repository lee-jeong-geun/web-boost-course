package kr.or.connect.reservation.category.controller;

import kr.or.connect.reservation.category.dto.CategoryDto;
import kr.or.connect.reservation.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Map<String, Object> categories() {
        Map<String, Object> map = new HashMap<>();
        List<CategoryDto> list = categoryService.getCategories();
        map.put("items", list);
        return map;
    }
}
