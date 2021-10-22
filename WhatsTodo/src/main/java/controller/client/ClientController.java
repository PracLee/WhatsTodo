package controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.client.ClientDAO;
import model.client.ClientVO;

@Controller
public class ClientController {
	@RequestMapping("/login.do")
	public String login(ClientVO vo, ClientDAO dao) {
		ClientVO data = null;	// DAO 설정 후에 다시 작성
		return "main.do";				// DAO 설정 후에 로직 생성
	}
	
	@RequestMapping("/insertClient.do")
	public String insertClient(ClientVO vo, ClientDAO dao) {
		
		return "main.do";
	}
	
	@RequestMapping("/updateClient.do")
	public String updateClient(ClientVO vo, ClientDAO dao){
		return "main.do";
	}
	
	@RequestMapping("/deleteClient.do")
	public String deleteClient(ClientVO vo, ClientDAO dao) {
		return "index";
	}
}
