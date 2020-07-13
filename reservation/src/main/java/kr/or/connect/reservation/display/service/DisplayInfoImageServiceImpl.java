package kr.or.connect.reservation.display.service;

import kr.or.connect.reservation.display.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.display.dto.DisplayInfoImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService {
    private DisplayInfoImageDao displayInfoImageDao;

    @Autowired
    public DisplayInfoImageServiceImpl(DisplayInfoImageDao displayInfoImageDao) {
        this.displayInfoImageDao = displayInfoImageDao;
    }

    @Override
    public DisplayInfoImageDto getDisplayInfoImage(int displayInfoId) {
        return displayInfoImageDao.selectByDisplayInfoId(displayInfoId);
    }
}
