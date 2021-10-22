package model.client;

import org.springframework.stereotype.Repository;

@Repository
public class ClientVO {
	private String id;
	private String pw;
	private String name;
	private int todoCnt;
	private int achieveCnt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTodoCnt() {
		return todoCnt;
	}
	public void setTodoCnt(int todoCnt) {
		this.todoCnt = todoCnt;
	}
	public int getAchieveCnt() {
		return achieveCnt;
	}
	public void setAchieveCnt(int achieveCnt) {
		this.achieveCnt = achieveCnt;
	}
	
	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", pw=" + pw + ", name=" + name + ", todoCnt=" + todoCnt + ", achieveCnt="
				+ achieveCnt + "]";
	}
	
	
}
