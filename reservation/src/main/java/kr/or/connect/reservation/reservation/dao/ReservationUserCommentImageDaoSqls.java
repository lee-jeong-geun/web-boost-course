package kr.or.connect.reservation.reservation.dao;

public class ReservationUserCommentImageDaoSqls {
    public static final String SELECT_BY_COMMENTID_SQL =
            "select " +
            " t1.id imageId, " +
            " t1.reservation_info_id reservationInfoId, " +
            " t1.reservation_user_comment_id reservationUserCommentId, " +
            " t1.file_id fileId, " +
            " t2.file_name fileName, " +
            " t2.save_file_name saveFileName, " +
            " t2.content_type contentType, " +
            " t2.delete_flag deleteFlag, " +
            " t2.create_date createDate, " +
            " t2.modify_date modifyDate " +
            "from " +
            " reservation_user_comment_image t1 " +
            "join file_info t2 on " +
            " t1.file_id = t2.id " +
            "where " +
            " t1.reservation_user_comment_id = :id";
}
