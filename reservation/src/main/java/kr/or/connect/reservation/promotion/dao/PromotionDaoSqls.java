package kr.or.connect.reservation.promotion.dao;

public class PromotionDaoSqls {
    public static final String SELECT_ALL_SQL = "select t1.id, t1.product_id productId, t3.file_name productImageUrl from promotion t1 join product_image t2 on t1.product_id = t2.product_id join file_info t3 on t2.file_id = t3.id where t2.type = 'th'";
}
