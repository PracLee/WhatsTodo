package model.client;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAO {
	// CRUD
	final String insertSQL = "insert into (id, pw, name) Client values(?,?,?)";
	final String selectOneSQL = "select * from Client where id = ? and pw = ?";
	final String selectAllSQL = "select * from Client";
	final String updateSQL = "update Client set pw = ? name = ? where id = ?";
	final String deleteSQL = "delete Client where id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertClient(ClientVO vo) {
		Object[] args = {vo.getId(), vo.getPw(), vo.getName()};
		jdbcTemplate.update(insertSQL, args);
	}

	public ClientVO selectOne(ClientVO vo) {
		Object[] args = {vo.getId(), vo.getPw()};
		return jdbcTemplate.queryForObject(selectOneSQL, args, new ClientRowMapper());
	}

	public List<ClientVO> selectAll(){
		return jdbcTemplate.query(selectAllSQL, new ClientRowMapper());
	}
	public void updateClient(ClientVO vo) {
		Object[] args = {vo.getPw(), vo.getName(), vo.getId()};
		jdbcTemplate.update(updateSQL, args);
	}
	public void deleteClient(ClientVO vo) {
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
}

class ClientRowMapper implements RowMapper<ClientVO>{

	@Override
	public ClientVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientVO data = new ClientVO();
		data.setId(rs.getString("id"));
		data.setPw(rs.getString("pw"));
		data.setName(rs.getString("name"));
		data.setTodoCnt(rs.getInt("todoCnt"));
		data.setAchieveCnt(rs.getInt("achieveCnt"));
		return data;
	}

}
