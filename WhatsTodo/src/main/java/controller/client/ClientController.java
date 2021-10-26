package controller.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.client.ClientService;
import model.client.ClientVO;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping("/goLogin.do")
	public String goLogin() {
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(ClientVO vo, HttpServletRequest request) {
		ClientVO data = service.getOneClient(vo);
		if(data==null) {
			return "index";
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
		service.updateClient(vo);
		return "main.do";
	}
	
	@RequestMapping("/deleteClient.do")
	public String deleteClient(ClientVO vo) {
		service.deleteClient(vo);
		return "index";
	}
}
