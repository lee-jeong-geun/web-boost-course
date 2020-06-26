package kr.or.connect.reservation.promotion.controller;

import kr.or.connect.reservation.promotion.dto.PromotionDto;
import kr.or.connect.reservation.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/promotions")
public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public Map<String, Object> getPromotions() {
        Map<String, Object> map = new HashMap<>();
        List<PromotionDto> list = promotionService.getPromotions();
        map.put("items", list);
        return map;
    }
}
