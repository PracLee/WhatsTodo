package controller.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		// Get Popular Todos
		List<TodoVO> allTodo = service.getAllTodoList();
		if(allTodo.size()!=0) {
			// popTodo
			ArrayList<TodoVO> popularTodo = new ArrayList<TodoVO>();
			// counting Todo
			ArrayList<Integer> cnt = new ArrayList<Integer>();
			
			// 구현중
			for(int i = 0; i < allTodo.size(); i++) {
				int tmpCnt = 0;
				String tmp = allTodo.get(i).getTodo();
				for(int j = 0; j < allTodo.size(); j++) {
					if(tmp.equals(allTodo.get(j).getTodo())) {
						tmpCnt++;
					}
				}
				cnt.set(i, tmpCnt);
			}
			model.addAttribute("popTodo", popularTodo);
		}
		
		// Show My Todos
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        model.addAttribute("today", strToday);
		ClientVO data = (ClientVO)session.getAttribute("ClientData");
		vo.setCid(data.getId());
		List<TodoVO>datas = service.getMyTodoList(vo);
		if(datas.size()!=0) {
			for(int i =0; i<datas.size();i++) {
				String deadLine = datas.get(i).getDeadLine();
				String sliceDate = deadLine.substring(0,deadLine.lastIndexOf(" "));
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
	
	@RequestMapping("/achieveTodo.do")
	public void achieveTodo(TodoVO vo, HttpServletResponse response) {
		service.updateAchieve(vo);
		try {
			PrintWriter out = response.getWriter();
			out.print(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
