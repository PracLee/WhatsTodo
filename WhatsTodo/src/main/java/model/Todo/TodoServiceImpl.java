package model.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	TodoDAO dao;
	// 비즈니스 메소드
	@Override
	public void insertTodo(TodoVO vo) {
		// TODO Auto-generated method stub
		dao.insertClient(vo);
	}
	
	@Override
	public List<TodoVO> getAllTodoList() {
		// TODO Auto-generated method stub
		return dao.selectAllTodo();
	}

	@Override
	public TodoVO getOneTodo(TodoVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOne(vo);
	}

	@Override
	public void updateTodo(TodoVO vo) {
		// TODO Auto-generated method stub
		dao.updateClient(vo);
	}

	@Override
	public void deleteTodo(TodoVO vo) {
		// TODO Auto-generated method stub
		dao.deleteClient(vo);
	}
	
	
	// 추가 기능
	@Override
	public List<TodoVO> getMyTodoList(TodoVO vo) {
		// TODO Auto-generated method stub
		return dao.selectMyTodo(vo);
	}
	
	@Override
	public void updateAchieve(TodoVO vo) {
		// TODO Auto-generated method stub
		dao.achieveTodo(vo);
	}

}
