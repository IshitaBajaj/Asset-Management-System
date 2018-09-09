package com.cg.artistsmanagementsystem.bean;

public class UserBean {
	private int userId;
	private String userPwd;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public UserBean(int userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public UserBean() {
		super();
	}
	
	
}
