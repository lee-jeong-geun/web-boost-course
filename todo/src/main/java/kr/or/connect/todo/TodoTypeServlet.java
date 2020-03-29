package kr.or.connect.todo;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 5335641695867753425L;

	private enum Type {
		TODO, DOING, DONE;

		private static Type[] typeList = values();

		public Type nextElement() {
			return typeList[(this.ordinal() + 1) % typeList.length];
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text;UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		HashMap<String, String> map = objectMapper.readValue(request.getReader(),
				new TypeReference<HashMap<String, String>>() {});

		TodoDto todoDto = new TodoDto();
		todoDto.setId(Long.parseLong(map.get("id")));
		todoDto.setType(Type.valueOf(map.get("type")).nextElement().toString());

		TodoDao todoDao = new TodoDao();
		todoDao.updateTodo(todoDto);
	}

}
