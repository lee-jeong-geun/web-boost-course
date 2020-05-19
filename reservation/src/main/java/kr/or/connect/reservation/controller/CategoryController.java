package kr.or.connect.reservation.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {
    @GetMapping
    public Map<String, Object> categories(ModelMap model) {

        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("id");
        list.add("name");
        list.add("count");
        map.put("items", list);
        return map;
    }
}
