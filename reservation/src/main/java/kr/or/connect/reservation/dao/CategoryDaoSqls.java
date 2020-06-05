package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
    public static final String SELECT_ALL_SQL = "select t1.id, t1.name, count(*) count from category t1 join product t2 on t1.id = t2.category_id join display_info t3 on t2.id = t3.product_id group by t1.id";
    public static final String SELECT_COUNT_SQL = "select count(*) from category t1 join product t2 on t1.id = t2.category_id where t1.id = :id group by t1.id";
    public static final String SELECT_ALL_COUNT_SQL = "select count(*) from product";
}
