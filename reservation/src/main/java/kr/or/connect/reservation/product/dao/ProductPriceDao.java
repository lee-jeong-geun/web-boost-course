package kr.or.connect.reservation.product.dao;

import kr.or.connect.reservation.product.dto.ProductPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.product.dao.ProductPriceDaoSqls.*;

@Repository
public class ProductPriceDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ProductPriceDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDto.class);

    @Autowired
    public ProductPriceDao(DataSource dataSource) {
        jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ProductPriceDto> selectByProductId(int displayInfoId) {
        Map<String, ?> param = Collections.singletonMap("id", displayInfoId);
        return jdbc.query(SELECT_BY_PRODUCTID_SQL, param, rowMapper);
    }
}
