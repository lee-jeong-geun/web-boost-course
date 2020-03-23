package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/connectdb";
	private static final String dbUser = "connectuser";
	private static final String dbPasswd = "connect123!@#";
	private static final String getTodosSql = "select * from todo order by id";
	private static final String updateTodoSql = "update todo set type = ? where id = ?";

	public int addTodo(TodoDto todo) {
		return 0;
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(getTodosSql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Long id = rs.getLong("id");
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type").toLowerCase();
					String regDate = rs.getDate("regdate").toString();
					TodoDto todoDto = new TodoDto(id, name, regDate, sequence, title, type);
					list.add(todoDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int updateTodo(TodoDto todo) {
		int updateCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(updateTodoSql)) {
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());
			
			updateCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateCount;
	}
}
