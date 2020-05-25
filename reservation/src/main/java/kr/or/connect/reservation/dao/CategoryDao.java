package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.CategoryDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.CategoryDaoSqls.SELECT_ALL_SQL;
import static kr.or.connect.reservation.dao.CategoryDaoSqls.SELECT_COUNT_SQL;

@Repository
public class CategoryDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<CategoryDto> rowMapper = BeanPropertyRowMapper.newInstance(CategoryDto.class);

    public CategoryDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<CategoryDto> selectAll() {
        return jdbc.query(SELECT_ALL_SQL, rowMapper);
    }

    public int selectCount(int id) {
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject(SELECT_COUNT_SQL, params, Integer.class);
    }
}
