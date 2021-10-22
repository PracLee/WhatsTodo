package model.Todo;

public class TodoVO {
	private int todoNum;
	private String todo;
	private String cid;
	private boolean achieveTodo;
	
	// get set
	public int getTodoNum() {
		return todoNum;
	}
	public void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public boolean isAchieveTodo() {
		return achieveTodo;
	}
	public void setAchieveTodo(boolean achieveTodo) {
		this.achieveTodo = achieveTodo;
	}
	
	//toString
	@Override
	public String toString() {
		return "TodoVO [todoNum=" + todoNum + ", todo=" + todo + ", cid=" + cid + ", achieveTodo=" + achieveTodo + "]";
	}
}
