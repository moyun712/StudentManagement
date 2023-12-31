package model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	public User(String username, String password, String level) {
		this.username = username;
		this.password = password;
		this.level = level;
	}
	public  User(){}
	private String username;//用户名
	private String password;//密码
	private String level;//权限级别
	
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
