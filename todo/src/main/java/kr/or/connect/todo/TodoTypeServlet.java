package kr.or.connect.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text;UTF-8");

		TodoDao todoDao = new TodoDao();
		PrintWriter out = response.getWriter();
		BufferedReader reader = request.getReader();
		ObjectMapper objectMapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();

		map = objectMapper.readValue(reader, new TypeReference<HashMap<String, String>>() {});
		if (map == null) {
			out.print("read error");
			return;
		}
		
		TodoDto todo = new TodoDto();
		Long id = Long.parseLong(map.get("id"));

		todo.setId(id);
		if ("TODO".equals(map.get("type"))) {
			todo.setType("DOING");
		} else {
			todo.setType("DONE");
		}

		if (todoDao.updateTodo(todo) > 0) {
			out.print("success");
		} else {
			out.print("update fail");
		}

	}

}
