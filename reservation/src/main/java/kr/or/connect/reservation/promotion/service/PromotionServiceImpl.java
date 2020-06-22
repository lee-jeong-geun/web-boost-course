package kr.or.connect.reservation.promotion.service;

import kr.or.connect.reservation.promotion.dao.PromotionDao;
import kr.or.connect.reservation.promotion.dto.PromotionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService{

    private PromotionDao promotionDao;

    @Autowired
    public PromotionServiceImpl(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    @Override
    public List<PromotionDto> getPromotions() {
        return promotionDao.selectAll();
    }
}
