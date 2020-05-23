package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
    public static final String SELECT_SQL = "select t1.id, t1.name, count(*) as count from category as t1 join product as t2 on t1.id = t2.category_id group by t1.id";
}
