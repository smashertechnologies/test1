package com.saloonsuite.dao;

import com.saloonsuite.dao.base.BaseDAO;
import com.saloonsuite.data.entity.UserInfo;


//Interface for user_info table.
public interface UserInfoDAO extends BaseDAO {

	public void setUserInfo(UserInfo userInfo);
	public UserInfo getUserInfo();
	
	
}
