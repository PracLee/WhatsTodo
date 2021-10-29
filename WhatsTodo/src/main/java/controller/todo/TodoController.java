package controller.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        System.out.println("today : "+strToday);
        model.addAttribute("today", strToday);
		ClientVO data = (ClientVO)session.getAttribute("ClientData");
		vo.setCid(data.getId());
		List<TodoVO>datas = service.getMyTodoList(vo);
		if(datas.size()!=0) {
			for(int i =0; i<datas.size();i++) {
				String deadLine = datas.get(i).getDeadLine();
				System.out.println("Origin deadLine : "+deadLine);
				String sliceDate = deadLine.substring(0,deadLine.lastIndexOf(" "));
				System.out.println("자른 sliceDate : "+sliceDate);
				datas.get(i).setDeadLine(sliceDate);
			}
			model.addAttribute("TodoDatas", datas);			
		}
		return "main.jsp";
	}
	
	@RequestMapping("/deleteTodo.do")
	public void deleteTodo(TodoVO vo, HttpServletResponse response) {
		System.out.println("여긴 오니?");
		service.deleteTodo(vo);
		try {
			PrintWriter out =response.getWriter();
			out.print(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	@RequestMapping("/updateTodo.do")
	public void updateTodo(TodoVO vo, HttpServletResponse response) {
		System.out.println("updateTodoVO = " + vo);
		service.updateTodo(vo);
		String data = vo.getTodo();
		try {
			PrintWriter out =response.getWriter();
			out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
