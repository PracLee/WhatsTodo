package controller.todo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Todo.TodoDAO;
import model.Todo.TodoVO;
import model.client.ClientVO;

@Controller
public class TodoController {
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm = new HashMap<String, String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	@RequestMapping("/insertTodo.do")
	public String insertTodo(TodoVO vo, TodoDAO dao) {
		return "redirect:main.do";
	}
	@RequestMapping("/main.do")
	public String mainAction(HttpServletRequest request, TodoVO vo, TodoDAO dao, Model model) {
		HttpSession session = request.getSession();
		ClientVO data = (ClientVO)session.getAttribute("clientInfo");
		vo.setCid(data.getId());
		model.addAttribute("datas", data);
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
