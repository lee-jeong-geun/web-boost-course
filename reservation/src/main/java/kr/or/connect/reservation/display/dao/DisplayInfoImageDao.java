package kr.or.connect.reservation.display.dao;

import kr.or.connect.reservation.display.dto.DisplayInfoImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

import static kr.or.connect.reservation.display.dao.DisplayInfoImageDaoSqls.*;

@Repository
public class DisplayInfoImageDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DisplayInfoImageDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImageDto.class);

    @Autowired
    public DisplayInfoImageDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public DisplayInfoImageDto selectByDisplayInfoId(int displayInfoId) {
        Map<String, Object> param = Collections.singletonMap("id", displayInfoId);
        return jdbc.queryForObject(SELECT_BY_DISPLAYINFOID_SQL, param, rowMapper);
    }
}
