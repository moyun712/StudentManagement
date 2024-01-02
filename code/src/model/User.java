package model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	public User(String username, String password, int level) {
		this.username = username;
		this.password = password;
		this.level = level;
	}
	public  User(){}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	private String username;//用户名
	private String password;//密码
	private int level;//权限级别
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
