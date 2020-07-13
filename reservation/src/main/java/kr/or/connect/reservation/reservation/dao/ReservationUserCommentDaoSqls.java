package kr.or.connect.reservation.reservation.dao;

public class ReservationUserCommentDaoSqls {
    public static final String SELECT_BY_DISPLAYINFOID_SQL =
            "select " +
            " t3.id commentId, " +
            " t1.id productId, " +
            " t2.id reservationInfoId, " +
            " t3.score score, " +
            " t3.comment comment, " +
            " t2.reservation_name reservationName, " +
            " t2.reservation_tel reservationTelephone, " +
            " t2.reservation_email reservationEmail, " +
            " t2.reservation_date reservationDate, " +
            " t3.create_date createDate, " +
            " t3.modify_date modifyDate " +
            "from " +
            " product t1 " +
            "join reservation_info t2 on " +
            " t1.id = t2.product_id " +
            "join reservation_user_comment t3 on " +
            " t2.id = t3.reservation_info_id " +
            "where t1.id = :id " +
            "order by " +
            " t3.id desc";
}
