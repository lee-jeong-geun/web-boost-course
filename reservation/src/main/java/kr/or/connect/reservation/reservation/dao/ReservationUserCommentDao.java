package kr.or.connect.reservation.reservation.dao;

import kr.or.connect.reservation.reservation.dto.ReservationUserCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.reservation.dao.ReservationUserCommentDaoSqls.*;

@Repository
public class ReservationUserCommentDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationUserCommentDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentDto.class);

    @Autowired
    public ReservationUserCommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ReservationUserCommentDto> selectByProductId(int displayInfoId) {
        Map<String, Object> param = Collections.singletonMap("id", displayInfoId);
        return jdbc.query(SELECT_BY_PRODUCTID_SQL, param, rowMapper);
    }

}
