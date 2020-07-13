package kr.or.connect.reservation.display.dao;

import kr.or.connect.reservation.display.dto.DisplayInfo;
import kr.or.connect.reservation.display.dto.DisplayInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

import static kr.or.connect.reservation.display.dao.DisplayInfoDaoSqls.*;

@Repository
public class DisplayInfoDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DisplayInfoDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDto.class);

    @Autowired
    public DisplayInfoDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public DisplayInfoDto selectById(int displayInfoId) {
        Map<String, Object> param = Collections.singletonMap("id", displayInfoId);
        return jdbc.queryForObject(SELECT_BY_ID_SQL, param, rowMapper);
    }
}
