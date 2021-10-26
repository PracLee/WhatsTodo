package controller.todo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Todo.TodoService;
import model.Todo.TodoVO;
import model.client.ClientVO;

@Controller
@SessionAttributes("data")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@RequestMapping("/insertTodo.do")
	public String insertTodo(TodoVO vo) {
		return "redirect:main.do";
	}
	
	@RequestMapping("/main.do")
	public String mainAction(HttpSession session, TodoVO vo, Model model) {
		ClientVO data = (ClientVO)session.getAttribute("ClientData");
		System.out.println("logindata : "+data);
		vo.setCid(data.getId());
		System.out.println("vodata : "+vo);
		List<TodoVO>datas = service.getMyTodoList(vo);
		if(datas.size()!=0) {
			model.addAttribute("datas", datas);			
		}
		return "main.jsp";
	}
	
	@RequestMapping("/deleteTodo.do")
	public String deleteTodo(TodoVO vo) {
		service.deleteTodo(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/updateTodo.do")
	public String updateTodo(TodoVO vo) {
		service.updateTodo(vo);
		return "redirect:main.do";
	}
}
