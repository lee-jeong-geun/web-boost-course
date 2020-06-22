package kr.or.connect.reservation.promotion.service;

import kr.or.connect.reservation.promotion.dto.PromotionDto;

import java.util.List;

public interface PromotionService {
    List<PromotionDto> getPromotions();
}
