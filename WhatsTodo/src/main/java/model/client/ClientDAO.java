package model.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAO {
	// CRUD
	final String insertSQL = "insert into (id, pw, name) ClientData values(?,?,?)";
	final String selectOneSQL = "select * from ClientData where id = ?, pw = ?";
	final String selectAllSQL = "select * from ClientData";
	final String ubdateSQL = "update ClientData set pw = ? name = ? where id = ?";
	final String deleteSQL = "delete ClientData where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertClient(ClientVO vo) {
		Object[] args = {vo.getId(), vo.getPw(), vo.getName()};
		jdbcTemplate.update(insertSQL, args);
	}
}
