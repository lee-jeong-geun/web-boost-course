package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/connectdb?characterEncoding=UTF-8";
	private static final String DB_USER = "connectuser";
	private static final String DB_PASSWD = "connect123!@#";
	private static final String ADD_TODO_SQL = "insert into todo(title, name, sequence) values(?, ?, ?)";
	private static final String GET_TODOS_SQL = "select * from todo order by id";
	private static final String UPDATE_TODO_SQL = "update todo set type = ? where id = ?";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addTodo(TodoDto todo) {
		int addCount = 0;

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
				PreparedStatement ps = conn.prepareStatement(ADD_TODO_SQL)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			addCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return addCount;
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
				PreparedStatement ps = conn.prepareStatement(GET_TODOS_SQL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Long id = rs.getLong("id");
				String title = rs.getString("title");
				String name = rs.getString("name");
				int sequence = rs.getInt("sequence");
				String type = rs.getString("type");
				String regDate = rs.getDate("regdate").toString();
				TodoDto todoDto = new TodoDto(id, name, regDate, sequence, title, type);
				list.add(todoDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int updateTodo(TodoDto todo) {
		int updateCount = 0;

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
				PreparedStatement ps = conn.prepareStatement(UPDATE_TODO_SQL)) {
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());

			updateCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateCount;
	}
}
