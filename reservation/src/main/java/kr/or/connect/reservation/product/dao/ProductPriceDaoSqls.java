package kr.or.connect.reservation.product.dao;

public class ProductPriceDaoSqls {
    public static final String SELECT_BY_PRODUCTID_SQL = "select t1.id productPriceId, " +
            "t2.id productId, " +
            "t1.price_type_name priceTypeName, " +
            "t1.price, " +
            "t1.discount_rate discountRate, " +
            "t1.create_date createDate, " +
            "t1.modify_date modifyDate " +
            "from product_price t1 " +
            "join product t2 on t1.product_id = t2.id " +
            "join display_info t3 on t2.id = t3.product_id " +
            "where t1.product_id = :id " +
            "order by t1.id desc";
}
