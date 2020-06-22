package kr.or.connect.reservation.promotion.dao;

import kr.or.connect.reservation.promotion.dto.PromotionDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.or.connect.reservation.promotion.dao.PromotionDaoSqls.SELECT_ALL_SQL;

@Repository
public class PromotionDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(PromotionDto.class);

    public PromotionDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<PromotionDto> selectAll() {
        return jdbc.query(SELECT_ALL_SQL, rowMapper);
    }
}
