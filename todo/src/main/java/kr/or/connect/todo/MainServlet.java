package kr.or.connect.todo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 7719687862473166847L;

	public enum Type {
		TODO, DOING, DONE;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoDao dao = new TodoDao();

		Map<String, List<TodoDto>> list = dao.getTodos().stream().collect(Collectors.groupingBy(TodoDto::getType));
		for (Type type : Type.values()) {
			request.setAttribute(type.toString(), list.get(type.toString()));
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
		requestDispatcher.forward(request, response);
	}

}
