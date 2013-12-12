package com.saloonsuite.data.entity;

public class UserLogin extends DataObject{

	private String _userId;
	private String _userName;
	private Integer _activated;
	private Integer _resetPassword;
	private String _password;
	
	public UserLogin() {
		
	}
	
	public UserLogin(String userId,String userName,String password,Integer activated,Integer resetPassword) {
		this._userId = userId;
		this._userName = userName;
		this._password = password;
		this._activated = activated;
		this._resetPassword = resetPassword;
	}
	
	public void setPassword(String password) {
		this._password = password;
	}
	
	public String getPassword() {
		return this._password;
	}
	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Integer getActivated() {
		return _activated;
	}

	public void setActivated(Integer activated) {
		_activated = activated;
	}

	public Integer getResetPassword() {
		return _resetPassword;
	}

	public void setResetPassword(Integer resetPassword) {
		_resetPassword = resetPassword;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

}
