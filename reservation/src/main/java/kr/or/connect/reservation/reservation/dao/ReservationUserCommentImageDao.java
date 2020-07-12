package kr.or.connect.reservation.reservation.dao;

import kr.or.connect.reservation.reservation.dto.ReservationUserCommentImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.reservation.dao.ReservationUserCommentImageDaoSqls.*;

@Repository
public class ReservationUserCommentImageDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationUserCommentImageDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImageDto.class);

    @Autowired
    public ReservationUserCommentImageDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ReservationUserCommentImageDto> selectByCommentId(int commentId) {
        Map<String, Object> param = Collections.singletonMap("id", commentId);
        return jdbc.query(SELECT_BY_COMMENTID_SQL, param, rowMapper);
    }
}
