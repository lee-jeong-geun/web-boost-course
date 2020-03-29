package kr.or.connect.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/register")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = -7459151427945989528L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TodoDto todoDto = new TodoDto();
		todoDto.setTitle(request.getParameter("new_title"));
		todoDto.setName(request.getParameter("new_name"));
		todoDto.setSequence(Integer.parseInt(request.getParameter("new_sequence")));

		TodoDao todoDao = new TodoDao();
		todoDao.addTodo(todoDto);

		response.sendRedirect("main");
	}

}
