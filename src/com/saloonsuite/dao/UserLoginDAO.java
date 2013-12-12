package com.saloonsuite.dao;

import com.saloonsuite.dao.base.BaseDAO;
import com.saloonsuite.data.entity.UserLogin;

//Interface for user_login_info table.
public interface UserLoginDAO extends BaseDAO {

	public void setUserLogin(UserLogin obj);
	public UserLogin getUserLogin();
	public UserLogin getLoginForUserId(String strUserId);
	
	
}
