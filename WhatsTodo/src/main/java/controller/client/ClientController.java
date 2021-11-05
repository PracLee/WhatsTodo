package controller.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.client.ClientService;
import model.client.ClientVO;

@Controller
@SessionAttributes("data")
public class ClientController {

	@Autowired
	private ClientService service;

	@RequestMapping("/goLogin.do")
	public String goLogin() {
		return "redirect:login.jsp";
	}

	@RequestMapping("/login.do")
	public String login(ClientVO vo, HttpServletRequest request, HttpServletResponse response) {
		if(vo.getId().equals("") || vo.getPw()==null) {
			return "index.jsp";
		}
		ClientVO data = service.getOneClient(vo);
		if(data==null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Check Your ID, PassWord!');");
				out.println("history.go(-1);");
				out.println("</script>");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("ClientData", data);
		return "main.do";				
	}

	@RequestMapping("/insertClient.do")
	public String insertClient(ClientVO vo, HttpSession session) {
		service.insertClient(vo);
		ClientVO data = service.getOneClient(vo);
		session.setAttribute("ClientData", data);
		return "main.do";
	}

	@RequestMapping("/updateClient.do")
	public String updateClient(ClientVO vo){
		System.out.println("updateClientVO : "+vo);
		service.updateClient(vo);
		return "login.do";
	}

	@RequestMapping("/deleteClient.do")
	public String deleteClient(ClientVO vo) {
		service.deleteClient(vo);
		return "index.jsp";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}

	// 추가기능
	@RequestMapping("/idCheck.do")
	public void idCheck(ClientVO vo, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			ClientVO data = service.idCheck(vo);
			if(data != null) {
				out.print("true");
			}
			else {
				out.print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("/googleRegister.do")
	public void googleRegister(ClientVO vo, HttpServletResponse response, HttpServletRequest request) {
		vo.setPw("googleUser");
		try {
			PrintWriter out = response.getWriter();
			System.out.println("Google Register Controller : "+vo);
			ClientVO data = service.idCheck(vo);
			if(data != null) {
				System.out.println("이미 존재하는 ID : 로그인 페이지로 돌아가기");
				out.print("ture");
			}
			else {
				System.out.println("존재하지 않는 ID : 회원가입 후 로그인");
				service.insertClient(vo);
				HttpSession session = request.getSession();
				session.setAttribute("ClientData", vo);
				out.print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("/googleLogin.do")
	public void googleLogin(ClientVO vo, HttpServletResponse response, HttpServletRequest request) {
		System.out.println("구글로그인!");
		vo.setPw("googleUser");
		ClientVO data = service.getOneClient(vo);
		try {
			PrintWriter out = response.getWriter();
			if(data==null) {
				// 로그인 실패
				out.print("false");
				return;
			}
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("ClientData", data);
			out.print("true");
			return;			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
