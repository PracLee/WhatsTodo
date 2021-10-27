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
		service.insertTodo(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/main.do")
	public String mainAction(HttpSession session, TodoVO vo, Model model) {
		ClientVO data = (ClientVO)session.getAttribute("ClientData");
		vo.setCid(data.getId());
		List<TodoVO>datas = service.getMyTodoList(vo);
		if(datas.size()!=0) {
			for(int i =0; i<datas.size();i++) {
				String deadLine = datas.get(i).getDeadLine();
				System.out.println("Origin deadLine : "+deadLine);
				String sliceDate = deadLine.substring(0,deadLine.lastIndexOf(" "));
				System.out.println("ÀÚ¸¥ sliceDate : "+sliceDate);
				datas.get(i).setDeadLine(sliceDate);
			}
			model.addAttribute("TodoDatas", datas);			
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
