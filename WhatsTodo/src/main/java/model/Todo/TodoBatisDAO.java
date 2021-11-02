package model.Todo;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TodoBatisDAO {
	@Autowired
	@Resource(name="sessionFactory")
	private SqlSessionTemplate mybatis;
	
	
	public void insertTodo(TodoVO vo) {
		mybatis.insert("tdao.insertTodo",vo);
		mybatis.update("tdao.cntUp",vo);
	}

	public TodoVO selectOne(TodoVO vo) {
		return mybatis.selectOne("tdao.selectTodo", vo);
	}
	public List<TodoVO> selectAllTodo(){
		return mybatis.selectList("tdao.selectAllTodo");
	}

	public void updateClient(TodoVO vo) {
		mybatis.update("tdao.updateTodo", vo);
	}
	public void deleteClient(TodoVO vo) {
		mybatis.update("tdao.cntDown", vo);
		mybatis.delete("tdao.deleteTodo", vo);
	}

	// 추가 기능
	public void achieveTodo(TodoVO vo) {
		mybatis.update("tdao.updateAcheive", vo);
	}

	public List<TodoVO> selectMyTodo(TodoVO vo){
		return mybatis.selectList("tdao.selectMyTodo", vo);
	}
	
	public List<TodoVO> showPreviousMyTodo(TodoVO vo){
		return mybatis.selectList("tdao.previousMyTodo", vo);
	}
}
