package model.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TodoDAO {
	// CRUD
	final String insertSQL = "insert into (todoNum, todo, cid, deadLine) TodoData values((SELECT NVL(MAX(todoNum),0) + 1 FROM TodoData),0),?,?,?)";
	final String selectOneSQL = "select * from TodoData where todoNum = ?";
	final String selectAllSQL = "select * from TodoData";
	final String updateSQL = "update TodoData set todo = ? deadLine = ? where todoNum = ?";
	final String deleteSQL = "delete TodoData where todoNum = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertClient(TodoVO vo) {
		Object[] args = {vo.getTodo(), vo.getCid(), vo.getDeadLine()};
		jdbcTemplate.update(insertSQL, args);
	}
	
	public TodoVO selectOne(TodoVO vo) {
		return jdbcTemplate.queryForObject(selectOneSQL, new TodoDataRowMapper());
	}

	public List<TodoVO> selectAll(){
		return jdbcTemplate.query(selectAllSQL, new TodoDataRowMapper());
	}
	public void updateClient(TodoVO vo) {
		Object[] args = {vo.getTodo(), vo.getDeadLine(), vo.getTodoNum()};
		jdbcTemplate.update(updateSQL, args);
	}
	public void deleteClient(TodoVO vo) {
		jdbcTemplate.update(deleteSQL, vo.getTodoNum());
	}
}

class TodoDataRowMapper implements RowMapper<TodoVO>{

	@Override
	public TodoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TodoVO data = new TodoVO();
		data.setTodoNum(rs.getInt("todoNum"));
		data.setTodo(rs.getString("todo"));
		data.setCid(rs.getString("cid"));
		data.setAchieveTodo(rs.getBoolean("achieveTodo"));
		data.setToDate(rs.getDate("toDate"));
		data.setDeadLine(rs.getDate("deadLine"));
		return data;
	}
	
}
