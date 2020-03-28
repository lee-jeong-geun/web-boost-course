package kr.or.connect.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoDao dao = new TodoDao();
		List<TodoDto> list = dao.getTodos();
		List<TodoDto> todoList = new ArrayList<>();
		List<TodoDto> doingList = new ArrayList<>();
		List<TodoDto> doneList = new ArrayList<>();
		
		todoList = list.stream().filter(t -> t.getType().equals("TODO")).collect(Collectors.toList());
		doingList = list.stream().filter(t -> t.getType().equals("DOING")).collect(Collectors.toList());
		doneList = list.stream().filter(t -> t.getType().equals("DONE")).collect(Collectors.toList());

		request.setAttribute("todoList", todoList);
		request.setAttribute("doingList", doingList);
		request.setAttribute("doneList", doneList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
		requestDispatcher.forward(request, response);
	}

}
