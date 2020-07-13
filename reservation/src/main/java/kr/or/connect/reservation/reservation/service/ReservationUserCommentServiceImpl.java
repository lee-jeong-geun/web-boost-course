package kr.or.connect.reservation.reservation.service;

import kr.or.connect.reservation.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.reservation.dao.ReservationUserCommentImageDao;
import kr.or.connect.reservation.reservation.dto.ReservationUserCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService {
    private ReservationUserCommentDao reservationUserCommentDao;
    private ReservationUserCommentImageDao reservationUserCommentImageDao;

    @Autowired
    public ReservationUserCommentServiceImpl(ReservationUserCommentDao reservationUserCommentDao,
                                             ReservationUserCommentImageDao reservationUserCommentImageDao) {
        this.reservationUserCommentDao = reservationUserCommentDao;
        this.reservationUserCommentImageDao = reservationUserCommentImageDao;
    }

    @Override
    public List<ReservationUserCommentDto> getReservationUserComments(int displayInfoId) {
        List<ReservationUserCommentDto> commentList = reservationUserCommentDao.selectByProductId(displayInfoId);
        for (ReservationUserCommentDto reservationUserCommentDto : commentList) {
            reservationUserCommentDto.setCommentImages(reservationUserCommentImageDao.selectByCommentId(reservationUserCommentDto.getCommentId()));
        }
        return commentList;
    }
}
