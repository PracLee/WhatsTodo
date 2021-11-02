package model.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientBatisDAO dao;
	// CRUD
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

	// 추가기능
	@Override
	public ClientVO idCheck(ClientVO vo) {
		// TODO Auto-generated method stub
		return dao.findIDCheck(vo);
	}
	
}
