package kr.or.connect.reservation.reservation.service;

import kr.or.connect.reservation.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.reservation.dto.ReservationUserCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService{
    private ReservationUserCommentDao reservationUserCommentDao;

    @Autowired
    public ReservationUserCommentServiceImpl(ReservationUserCommentDao reservationUserCommentDao) {
        this.reservationUserCommentDao = reservationUserCommentDao;
    }

    @Override
    public List<ReservationUserCommentDto> getReservationUserComments(int productId) {
        return reservationUserCommentDao.selectByProductId(productId);
    }
}
