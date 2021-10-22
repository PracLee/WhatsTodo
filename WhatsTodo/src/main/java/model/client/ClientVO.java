package model.client;

import org.springframework.stereotype.Repository;

@Repository
public class ClientVO {
	private String id;
	private String pw;
	private String name;
	private boolean admin;
	private int dayTodoCnt;
	private int weekTodoCnt;
	private int monthTodoCnt;
	private int yearTodoCnt;
	private int dayAchieve;
	private int weekAchieve;
	private int monthAchieve;
	private int yearAchieve;
	
	// get, set
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public int getDayTodoCnt() {
		return dayTodoCnt;
	}
	public void setDayTodoCnt(int dayTodoCnt) {
		this.dayTodoCnt = dayTodoCnt;
	}
	public int getWeekTodoCnt() {
		return weekTodoCnt;
	}
	public void setWeekTodoCnt(int weekTodoCnt) {
		this.weekTodoCnt = weekTodoCnt;
	}
	public int getMonthTodoCnt() {
		return monthTodoCnt;
	}
	public void setMonthTodoCnt(int monthTodoCnt) {
		this.monthTodoCnt = monthTodoCnt;
	}
	public int getYearTodoCnt() {
		return yearTodoCnt;
	}
	public void setYearTodoCnt(int yearTodoCnt) {
		this.yearTodoCnt = yearTodoCnt;
	}
	public int getDayAchieve() {
		return dayAchieve;
	}
	public void setDayAchieve(int dayAchieve) {
		this.dayAchieve = dayAchieve;
	}
	public int getWeekAchieve() {
		return weekAchieve;
	}
	public void setWeekAchieve(int weekAchieve) {
		this.weekAchieve = weekAchieve;
	}
	public int getMonthAchieve() {
		return monthAchieve;
	}
	public void setMonthAchieve(int monthAchieve) {
		this.monthAchieve = monthAchieve;
	}
	public int getYearAchieve() {
		return yearAchieve;
	}
	public void setYearAchieve(int yearAchieve) {
		this.yearAchieve = yearAchieve;
	}
	
	// toString
	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", pw=" + pw + ", name=" + name + ", admin=" + admin + ", dayTodoCnt="
				+ dayTodoCnt + ", weekTodoCnt=" + weekTodoCnt + ", monthTodoCnt=" + monthTodoCnt + ", yearTodoCnt="
				+ yearTodoCnt + ", dayAchieve=" + dayAchieve + ", weekAchieve=" + weekAchieve + ", monthAchieve="
				+ monthAchieve + ", yearAchieve=" + yearAchieve + "]";
	}
}
