package controller.todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Todo.TodoDAO;
import model.Todo.TodoVO;
import model.client.ClientVO;

@Controller
public class TodoController {
	@RequestMapping("/insertTodo.do")
	public String insertTodo(TodoVO vo, TodoDAO dao) {
		return "redirect:main.do";
	}
	@RequestMapping("/main.do")
	public String mainAction(HttpServletRequest request, TodoVO vo, TodoDAO dao) {
		HttpSession session = request.getSession();
		ClientVO data = (ClientVO)session.getAttribute("clientInfo");
		vo.setCid(data.getId());
		return "main.jsp";
	}
	@RequestMapping("/deleteTodo.do")
	public String deleteTodo(TodoVO vo, TodoDAO dao) {
		
		return "redirect:main.do";
	}
	@RequestMapping("/updateTodo.do")
	public String updateTodo(TodoVO vo, TodoDAO dao) {
		
		return "redirect:main.do";
	}
}
