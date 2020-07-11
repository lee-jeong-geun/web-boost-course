package kr.or.connect.reservation.product.dao;

public class ProductImageDaoSqls {
    public static final String SELECT_BY_PRODUCTIMAGE_SQL = "select t1.product_id productId, " +
            "t1.id productImageId, " +
            "t1.type type, " +
            "t1.file_id fileInfoId, " +
            "t2.file_name fileName, " +
            "t2.save_file_name saveFileName, " +
            "t2.content_type contentType, " +
            "t2.delete_flag deleteFlag, " +
            "t2.create_date createDate, " +
            "t2.modify_date modifyDate " +
            "from product_image t1 " +
            "join file_info t2 on t1.file_id = t2.id " +
            "where t1.product_id = :id and (t1.type = 'ma' or t1.type = 'et')";
}
