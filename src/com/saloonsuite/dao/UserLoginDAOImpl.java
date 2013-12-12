package com.saloonsuite.dao;

import static com.saloonsuite.dao.connection.ConnectionFactory.getConnection;
import static com.saloonsuite.util.UserLoginConstants.ACTIVATED_COL;
import static com.saloonsuite.util.UserLoginConstants.CREATE_USERLOGIN_QUERY;
import static com.saloonsuite.util.UserLoginConstants.RESET_PASSWORD_COL;
import static com.saloonsuite.util.UserLoginConstants.SELECT_ALL_USERINFO;
import static com.saloonsuite.util.UserLoginConstants.SELECT_USERLOGIN_BYUSERID;
import static com.saloonsuite.util.UserLoginConstants.SELECT_USERLOGIN_BYUSERNAME;
import static com.saloonsuite.util.UserLoginConstants.USERNAME_COL;
import static com.saloonsuite.util.UserLoginConstants.USER_ID_COL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.saloonsuite.data.entity.DataObject;
import com.saloonsuite.data.entity.UserLogin;
import com.saloonsuite.util.validator.BaseValidator;

public class UserLoginDAOImpl extends AbstractDAO implements UserLoginDAO{

	Logger log = Logger.getLogger(UserInfoDAOImpl.class);
	private UserLogin _userLogin = null;
	@Override
	public boolean create() {

		if ( this.getUserLogin() == null ) {
			log.error("Failed to create any user login information. No User login Information found to create.");
			return false;
		}
		
		boolean isSuccess = false;
		
		PreparedStatement pStmt = null;
		try {

			log.debug("UserLogin Information create query : "+ CREATE_USERLOGIN_QUERY);
			pStmt = getConnection().prepareStatement(CREATE_USERLOGIN_QUERY);
			pStmt.setString(1, this._userLogin.getUserId());
			pStmt.setString(2, this._userLogin.getUserName());
			pStmt.setString(3, this._userLogin.getPassword());
			pStmt.setInt(4, 1);//Activated By Default, if not activated then can not login.
			pStmt.setInt(5, 0);
			isSuccess = (pStmt.executeUpdate()>0);
			log.info("UserLogin Information created :" + isSuccess);
			
		} catch (SQLException e) {
			log.error("Error while creating new UserLogin Information");
			e.printStackTrace();
		} finally {close(pStmt);}
		
		return isSuccess;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists() {


		log.info("Getting Login Information for Username : " + this.getUserLogin().getUserName());

		PreparedStatement pStmt = null;
		ResultSet rSet = null;
		boolean exists = false;
		try {
			log.debug("Getting UserLogin Information by Username query : " + SELECT_USERLOGIN_BYUSERNAME);
			pStmt = getConnection().prepareStatement(SELECT_USERLOGIN_BYUSERNAME);
			pStmt.setString(1, this.getUserLogin().getUserName());
			rSet = pStmt.executeQuery();
			if(rSet.next()) {
				exists = true;
				log.info("User with username "+ this.getUserLogin().getUserName() +" exists.");
			} else {
				log.info("No UserLogin Information found for the given username : " + this.getUserLogin().getUserName());
			}
			return exists;
		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for UserLogin Info Records.");
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pStmt);
		}
		
		return exists;
	
	
	}

	@Override
	public DataObject get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserLogin> getAll() {

		ResultSet rSet = null;
		Statement stmt = null;
		try {
			log.info("Getting all UserLogin information with query : " + SELECT_ALL_USERINFO);
			stmt = getConnection().createStatement();
			rSet = stmt.executeQuery(SELECT_ALL_USERINFO);
			List<UserLogin> lstRecords = new ArrayList<UserLogin>();
			if(rSet.next()) {
				do{
					UserLogin obj = new UserLogin();
					obj.setUserId(rSet.getString(USER_ID_COL));
					obj.setUserName(rSet.getString(USERNAME_COL));
					obj.setActivated(rSet.getInt(ACTIVATED_COL));
					obj.setResetPassword(rSet.getInt(RESET_PASSWORD_COL));
					lstRecords.add(obj);
					
				}while(rSet.next());
				log.debug("UserLogin Information List :" + lstRecords);
				return lstRecords;
				
			} else {
				log.error("No User Login Information found.");
			}

		} catch (SQLException e) {
			System.err.println("Error while trying to fetch the data for UserLogin Info Records.");
			e.printStackTrace();
		} finally {
			close(rSet);
			close(stmt);
		}
		
		return null;
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserLogin getUserLogin() {
		return _userLogin;
	}

	@Override
	public void setUserLogin(UserLogin obj) {

		this._userLogin = obj;
		
	}

	@Override
	public UserLogin getLoginForUserId(String strUserId) {

		log.info("Getting Login Information for UserId : " + strUserId);
		if (BaseValidator.isNullOrBlank(strUserId)) {
			log.error("Invalid UserId for Getting login information :"  + strUserId +", Returning null");
			
			return null;
		}

		PreparedStatement pStmt = null;
		ResultSet rSet = null;
		try {
			log.debug("Getting UserLogin Information by UserId query : " + SELECT_USERLOGIN_BYUSERID);
			pStmt = getConnection().prepareStatement(SELECT_USERLOGIN_BYUSERID);
			pStmt.setString(1, strUserId);
			rSet = pStmt.executeQuery();
			UserLogin obj = new UserLogin();
			if(rSet.next()) {
					
					obj.setUserId(rSet.getString(USER_ID_COL));
					obj.setUserName(rSet.getString(USERNAME_COL));
					obj.setActivated(rSet.getInt(ACTIVATED_COL));
					obj.setResetPassword(rSet.getInt(RESET_PASSWORD_COL));
					
			} else {
				log.info("No UserLogin Information found for the given userId : " + strUserId);
			}
			log.debug("UserLogin Information Found from DB : " + obj);
			return obj;
		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for UserLogin Info Records.");
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pStmt);
		}
		
		return null;
	
	}

}
