package model.Todo;

import java.util.List;

public interface TodoService {
	public void insertTodo(TodoVO vo);
	public List<TodoVO> getMyTodoList(TodoVO vo);
	public TodoVO getOneTodo(TodoVO vo);
	public void updateTodo(TodoVO vo);
	public void deleteTodo(TodoVO vo);
}
