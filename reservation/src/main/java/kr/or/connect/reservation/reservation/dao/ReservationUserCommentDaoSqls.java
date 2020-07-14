package kr.or.connect.reservation.reservation.dao;

public class ReservationUserCommentDaoSqls {
    public static final String SELECT_BY_DISPLAYINFOID_SQL =
            "select " +
            " t1.id commentId, " +
            " t3.id productId, " +
            " t2.id reservationInfoId, " +
            " t1.score score, " +
            " t1.comment comment, " +
            " t2.reservation_name reservationName, " +
            " t2.reservation_tel reservationTelephone, " +
            " t2.reservation_email reservationEmail, " +
            " t2.reservation_date reservationDate, " +
            " t1.create_date createDate, " +
            " t1.modify_date modifyDate " +
            "from  " +
            " reservation_user_comment t1 " +
            "join reservation_info t2 on " +
            " t1.reservation_info_id = t2.id " +
            "join product t3 on " +
            " t1.product_id = t3.id " +
            "join display_info t4 on  " +
            " t4.product_id = t3.id " +
            "where " +
            " t4.id = :id " +
            "order by " +
            " t1.id desc";
}
