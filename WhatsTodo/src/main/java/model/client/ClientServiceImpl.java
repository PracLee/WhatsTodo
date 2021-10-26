package model.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientDAO dao;

	@Override
	public void insertClient(ClientVO vo) {
		// TODO Auto-generated method stub
		dao.insertClient(vo);
	}

	@Override
	public List<ClientVO> getClientList() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public ClientVO getOneClient(ClientVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOne(vo);
	}

	@Override
	public void updateClient(ClientVO vo) {
		// TODO Auto-generated method stub
		dao.updateClient(vo);
	}

	@Override
	public void deleteClient(ClientVO vo) {
		// TODO Auto-generated method stub
		dao.deleteClient(vo);
	}

}
