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
		System.out.println("insertTodo vo : "+ vo);
		service.insertTodo(vo);
		return "redirect:main.do";
	}

	@RequestMapping("/main.do")
	public String mainAction(HttpSession session, TodoVO vo, Model model) {
		// get Pop Todos
		model.addAttribute("popTodo", getPopTodo());

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

	@RequestMapping("/showComplete.do")
	public String showMyPreviousTodos(HttpSession session, TodoVO vo, Model model) {
		// getPopTodo
		model.addAttribute("popTodo", getPopTodo());
		
		// Show My Todos
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		model.addAttribute("today", strToday);
		ClientVO data = (ClientVO)session.getAttribute("ClientData");
		vo.setCid(data.getId());
		List<TodoVO>datas = service.showMyPrevious(vo);
		if(datas.size()!=0) {
			for(int i =0; i<datas.size();i++) {
				String deadLine = datas.get(i).getDeadLine();
				String sliceDate = deadLine.substring(0,deadLine.lastIndexOf(" "));
				datas.get(i).setDeadLine(sliceDate);
			}
			model.addAttribute("TodoDatas", datas);			
		}

		return "achieveTodos.jsp";
	}

	@RequestMapping("/deleteTodo.do")
	public void deleteTodo(TodoVO vo, HttpServletResponse response) {
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

	public List<TodoVO> getPopTodo() {
		// Get Popular Todos
		List<TodoVO> allTodo = service.getAllTodoList();
		// popTodo
		ArrayList<TodoVO> popularTodo = new ArrayList<TodoVO>();
		if(allTodo.size()!=0) {
			// counting Todo
			TodoVO firstTodo = allTodo.get(0);	// 빈도순 정렬이기 때문에 0번은 무조건 가장 많은 빈도
			TodoVO secondTodo=null;
			TodoVO thirdTodo=null;

			int firstIndex = firstTodo.getTodoCnt();	// 0번의 Cnt가 FirstTodo의 size
			int secondIndex;
			popularTodo.add(0, firstTodo);
			System.out.println("allTodo.size() = "+allTodo.size());
			System.out.println("firstIndex = "+firstIndex);
			if(allTodo.size()>firstIndex) {
				secondTodo = allTodo.get(firstIndex);
				secondIndex = secondTodo.getTodoCnt();

				popularTodo.add(1, secondTodo);

				if(allTodo.size()>firstIndex+secondIndex) {
					thirdTodo = allTodo.get(firstIndex+secondIndex);
					popularTodo.add(2, thirdTodo);	
				}
			}
		}
		System.out.println("popularTodo = " + popularTodo);
		return popularTodo;
	}
}
