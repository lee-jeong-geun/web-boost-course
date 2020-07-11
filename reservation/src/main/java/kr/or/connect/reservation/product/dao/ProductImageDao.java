package kr.or.connect.reservation.product.dao;

import kr.or.connect.reservation.product.dto.ProductImageDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.product.dao.ProductImageDaoSqls.*;

@Repository
public class ProductImageDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ProductImageDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductImageDto.class);

    public ProductImageDao(DataSource dataSource) {
        jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ProductImageDto> selectByProductId(int productId) {
        Map<String, ?> param = Collections.singletonMap("id", productId);
        return jdbc.query(SELECT_BY_PRODUCTIMAGE_SQL, param, rowMapper);

    }
}
