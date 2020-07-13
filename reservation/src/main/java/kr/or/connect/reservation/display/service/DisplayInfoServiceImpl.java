package kr.or.connect.reservation.display.service;

import kr.or.connect.reservation.display.dao.DisplayInfoDao;
import kr.or.connect.reservation.display.dto.DisplayInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService{
    private DisplayInfoDao displayInfoDao;

    @Autowired
    public DisplayInfoServiceImpl(DisplayInfoDao displayInfoDao) {
        this.displayInfoDao = displayInfoDao;
    }

    @Override
    public DisplayInfoDto getDisplayInfo(int displayInfoId) {
        return displayInfoDao.selectByDisplayInfoId(displayInfoId);
    }
}
