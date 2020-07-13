package kr.or.connect.reservation.reservation.service;

import kr.or.connect.reservation.reservation.dto.ReservationUserCommentDto;

import java.util.List;

public interface ReservationUserCommentService {
    List<ReservationUserCommentDto> getReservationUserComments(int displayInfoId);
}
