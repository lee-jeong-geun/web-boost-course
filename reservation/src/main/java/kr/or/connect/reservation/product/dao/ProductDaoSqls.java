package kr.or.connect.reservation.product.dao;

public class ProductDaoSqls {
    public static final String SELECT_PRODUCT_SQL = "select t1.id displayInfoId, t2.id productId, t2.description productDescription, t1.place_name placeName, t2.content productContent," +
            "t4.file_name productImageUrl from display_info t1 join product t2 on t1.product_id = t2.id join product_image t3 on t2.id = t3.product_id " +
            "join file_info t4 on t3.file_id = t4.id where t3.type = 'th' and t2.category_id = :id limit :start, :limit";

    public static final String SELECT_ALL_PRODUCT_SQL = "select t1.id displayInfoId, t2.id productId, t2.description productDescription, t1.place_name placeName, t2.content productContent," +
            "t4.file_name productImageUrl from display_info t1 join product t2 on t1.product_id = t2.id join product_image t3 on t2.id = t3.product_id " +
            "join file_info t4 on t3.file_id = t4.id where t3.type = 'th' limit :start, :limit";

    public static final String SELECT_COUNT_SQL = "select count(*) count from category t1 join product t2 on t1.id = t2.category_id join display_info t3 on t2.id = t3.product_id where t1.id = :id group by t1.id;";

    public static final String SELECT_ALL_COUNT_SQL = "select count(*) from display_info";
}
