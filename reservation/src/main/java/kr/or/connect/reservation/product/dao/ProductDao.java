package kr.or.connect.reservation.product.dao;

import kr.or.connect.reservation.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.product.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ProductDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductDto.class);

    @Autowired
    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ProductDto> selectById(int id, int start, int limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("start", start);
        params.put("limit", limit);
        return jdbc.query(SELECT_PRODUCT_SQL, params, rowMapper);
    }

    public List<ProductDto> selectAll(int start, int limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("limit", limit);
        return jdbc.query(SELECT_ALL_PRODUCT_SQL, params, rowMapper);
    }
}
