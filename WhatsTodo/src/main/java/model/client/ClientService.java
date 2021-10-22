package model.client;

import java.util.List;

public interface ClientService {
	public void insertClient(ClientVO vo);
	public List<ClientVO> getClientList();
	public ClientVO getOneClient(ClientVO vo);
	public void updateClient(ClientVO vo);
	public void deleteClient(ClientVO vo);
}
