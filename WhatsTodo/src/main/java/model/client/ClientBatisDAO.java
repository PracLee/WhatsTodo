package model.client;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientBatisDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertClient(ClientVO vo) {
		mybatis.insert("cdao.insertClient", vo);
	}

	public ClientVO selectOne(ClientVO vo) {
		return mybatis.selectOne("cdao.selectOne", vo);
	}

	public List<ClientVO> selectAll(){
		return mybatis.selectList("cdao.selectAll");
	}
	public void updateClient(ClientVO vo) {
		mybatis.update("cdao.updateClient", vo);
	}
	public void deleteClient(ClientVO vo) {
		mybatis.update("cdao.deleteClient", vo);
	}
	public ClientVO findIDCheck(ClientVO vo) {
		return mybatis.selectOne("cdao.idExistCheck", vo);
	}
	
}
