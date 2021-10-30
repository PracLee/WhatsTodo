package controller.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String login(ClientVO vo, HttpServletRequest request) {
		if(vo.getId().equals("") || vo.getPw()==null) {
			return "index.jsp";
		}
		ClientVO data = service.getOneClient(vo);
		if(data==null) {
			return "index.jsp";
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
	
	// ¹Ì±¸Çö
	@RequestMapping("googleRegister.do")
	public String googleRegister() {
		
		return "main.do";
	}
}
