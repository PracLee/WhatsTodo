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
	final String insertSQL = "insert into Todo (todoNum, todo, cid, deadLine) values ((SELECT NVL(MAX(todoNum),0) + 1 FROM Todo),?,?,?)";
	final String selectOneSQL = "select * from Todo where todoNum = ?";
	final String selectAllSQL = "select * from Todo where cid = ? and achieveTodo = 0 order by deadline";
	final String updateSQL = "update Todo set todo = ? where todoNum = ?";
	final String deleteSQL = "delete Todo where todoNum = ?";
	
	// 추가기능
	final String updateAchieve = "update Todo set achieveTodo = 1 where todoNum = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// 비즈니스 메소드
	public void insertClient(TodoVO vo) {
		System.out.println("insertClient vo = "+vo);
		jdbcTemplate.update(insertSQL, vo.getTodo(), vo.getCid(), vo.getDeadLine());
	}
	
	public TodoVO selectOne(TodoVO vo) {
		return jdbcTemplate.queryForObject(selectOneSQL, new TodoRowMapper());
	}

	public List<TodoVO> selectAll(TodoVO vo){
		return jdbcTemplate.query(selectAllSQL, new TodoRowMapper(), vo.getCid());
	}
	public void updateClient(TodoVO vo) {
		Object[] args = {vo.getTodo(), vo.getTodoNum()};
		jdbcTemplate.update(updateSQL, args);
	}
	public void deleteClient(TodoVO vo) {
		jdbcTemplate.update(deleteSQL, vo.getTodoNum());
	}
	
	// 추가 기능
	public void achieveTodo(TodoVO vo) {
		jdbcTemplate.update(updateAchieve, vo.getTodoNum());
	}
}

class TodoRowMapper implements RowMapper<TodoVO>{

	@Override
	public TodoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TodoVO data = new TodoVO();
		data.setTodoNum(rs.getInt("todoNum"));
		data.setTodo(rs.getString("todo"));
		data.setCid(rs.getString("cid"));
		data.setAchieveTodo(rs.getBoolean("achieveTodo"));
		data.setToDate(rs.getDate("toDate"));
		data.setDeadLine(rs.getString("deadLine"));
		System.out.println("TodoRowMapper data : " + data);
		return data;
	}
	
}
