package kr.or.connect.reservation.display.dao;

public class DisplayInfoImageDaoSqls {
    public static final String SELECT_BY_DISPLAYINFOID_SQL =
            "select " +
            " t1.id displayInfoImageId, " +
            " t1.display_info_id displayInfoId, " +
            " t1.file_id fileId, " +
            " t2.file_name fileName, " +
            " t2.save_file_name saveFileName, " +
            " t2.content_type contentType, " +
            " t2.delete_flag deleteFlag, " +
            " t2.create_date createDate, " +
            " t2.modify_date modifyDate " +
            "from " +
            " display_info_image t1 " +
            "join file_info t2 on " +
            " t1.file_id = t2.id " +
            "where " +
            " t1.display_info_id = :id;";
}
