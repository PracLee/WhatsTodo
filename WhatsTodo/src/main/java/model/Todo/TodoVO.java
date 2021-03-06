package model.Todo;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class TodoVO {
	private int todoNum;
	private String todo;
	private String cid;
	private boolean achieveTodo;
	private Date toDate;
	private String deadLine;
	private int todoCnt;
	
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
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public int getTodoCnt() {
		return todoCnt;
	}
	public void setTodoCnt(int todoCnt) {
		this.todoCnt = todoCnt;
	}
	
	//toString
	@Override
	public String toString() {
		return "TodoVO [todoNum=" + todoNum + ", todo=" + todo + ", cid=" + cid + ", achieveTodo=" + achieveTodo
				+ ", toDate=" + toDate + ", deadLine=" + deadLine + ", todoCnt=" + todoCnt + "]";
	}
	
	
}
