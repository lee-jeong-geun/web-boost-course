package kr.or.connect.reservation.reservation.service;

import kr.or.connect.reservation.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.reservation.dao.ReservationUserCommentImageDao;
import kr.or.connect.reservation.reservation.dto.ReservationUserCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> getReservationUserComments(int displayInfoId) {
        List<ReservationUserCommentDto> commentList = reservationUserCommentDao.selectByDisplayInfoId(displayInfoId);
        for (ReservationUserCommentDto reservationUserCommentDto : commentList) {
            reservationUserCommentDto.setCommentImages(reservationUserCommentImageDao.selectByCommentId(reservationUserCommentDto.getCommentId()));
        }
        int scoreSum = commentList.stream().mapToInt(ReservationUserCommentDto::getScore).sum();

        double averageScore = 0;
        if (!commentList.isEmpty()) {
            averageScore = (double) scoreSum / commentList.size();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("comments", commentList);
        result.put("averageScore", averageScore);
        return result;
    }
}
