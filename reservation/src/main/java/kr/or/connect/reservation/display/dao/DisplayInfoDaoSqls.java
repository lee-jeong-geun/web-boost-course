package kr.or.connect.reservation.display.dao;

public class DisplayInfoDaoSqls {
    public static final String SELECT_BY_ID_SQL =
            "select " +
            " t2.id productId, " +
            " t3.id categoryId, " +
            " t1.id displayInfoId, " +
            " t3.name categoryName, " +
            " t2.description productDescription, " +
            " t2.content productContent, " +
            " t2.event productEvent, " +
            " t1.opening_hours openingHours, " +
            " t1.place_name placeName, " +
            " t1.place_lot placeLot, " +
            " t1.place_street placeStreet, " +
            " t1.tel telephone, " +
            " t1.homepage homepage, " +
            " t1.email email, " +
            " t1.create_date createDate, " +
            " t1.modify_date modifyDate " +
            "from " +
            " display_info t1 " +
            "join product t2 on " +
            " t1.product_id = t2.id " +
            "join category t3 on " +
            " t2.category_id = t3.id " +
            "where t1.id = :id";
}
