package model.Todo;

import java.util.List;

public interface TodoService {
	// CRUD
	public void insertTodo(TodoVO vo);
	public List<TodoVO> getAllTodoList();
	public TodoVO getOneTodo(TodoVO vo);
	public void updateTodo(TodoVO vo);
	public void deleteTodo(TodoVO vo);
	
	// Ãß°¡
	public void updateAchieve(TodoVO vo);
	public List<TodoVO> getMyTodoList(TodoVO vo);
	public List<TodoVO> showMyPrevious(TodoVO vo);
}
