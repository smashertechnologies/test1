package com.saloonsuite.dao;

import static com.saloonsuite.dao.connection.ConnectionFactory.getConnection;
import static com.saloonsuite.util.UserInfoConstants.CREATE_NEW_USERINFO_QUERY;
import static com.saloonsuite.util.UserInfoConstants.EMAIL_COL;
import static com.saloonsuite.util.UserInfoConstants.FIRSTNAME_COL;
import static com.saloonsuite.util.UserInfoConstants.LASTNAME_COL;
import static com.saloonsuite.util.UserInfoConstants.MOBILENO;
import static com.saloonsuite.util.UserInfoConstants.SELECT_ALL_USERINFO;
import static com.saloonsuite.util.UserInfoConstants.SELECT_USERINFO_BYEMAIL;
import static com.saloonsuite.util.UserInfoConstants.USER_ID_COL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.saloonsuite.data.entity.UserInfo;
public class UserInfoDAOImpl extends AbstractDAO implements UserInfoDAO {

	Logger log = Logger.getLogger(UserInfoDAOImpl.class);
	private UserInfo userInfo = null;
	@Override
	public boolean create() {
		
		log.info("Creating new UserInfo");

		if(userInfo == null ) {
			log.error("Failed to create any user information. No User Information found to create.");
			return false;
		}

		boolean isSuccess = false;
		PreparedStatement pStmt = null;
		try {

			pStmt = getConnection().prepareStatement(CREATE_NEW_USERINFO_QUERY);
			pStmt.setString(1, userInfo.getFirstName());
			pStmt.setString(2, userInfo.getLastName());
			pStmt.setString(3, userInfo.getEmail());
			pStmt.setString(4, userInfo.getMobileNo());
			isSuccess = (pStmt.executeUpdate()>0);
			log.info("UserInfo Created : " + isSuccess);
			if ( isSuccess ) {

				this.userInfo = get();
				log.info("Creating UserLogin Info for the newly created UserInfo with UserId :" + this.userInfo.getUserId());
				UserLoginDAO dao = new UserLoginDAOImpl();
				this.userInfo.getLoginInfo().setUserId(this.userInfo.getUserId());
				dao.setUserLogin(this.userInfo.getLoginInfo());
				isSuccess = isSuccess && dao.create();
				log.info("UserLogin info created : " + isSuccess);
			}
			
		} catch (SQLException e) {
			log.error("Error while creating userinfo in DB");
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		
		return isSuccess;
	}
		

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists() {

		PreparedStatement pStmt = null;
		ResultSet rSet = null;
		try {

			boolean exists = false;
			log.debug("UserInfo Check (Username and Email ): " + SELECT_USERINFO_BYEMAIL);
			pStmt = getConnection().prepareStatement(SELECT_USERINFO_BYEMAIL);
			pStmt.setString(1, this.getUserInfo().getEmail());
			
			rSet = pStmt.executeQuery();
			if (rSet.next()) {
				log.debug("UserInfo with Email : " +this.getUserInfo().getEmail() +" exists");
				exists = true;
			}
			if ( !exists ){
				UserLoginDAO dao = new UserLoginDAOImpl();
				dao.setUserLogin(this.getUserInfo().getLoginInfo());
				exists = dao.exists();
			}
			
			return exists;
		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for UserInfo Records.");
			e.printStackTrace();
		} finally {
			
			close(rSet);
			close(pStmt);
		}
		
		return false;
	
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
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	@Override
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
		
	}

	@Override
	public List<UserInfo> getAll() {

		Statement stmt = null;
		ResultSet rSet = null;
		log.info("Searching all UserInfo from database");
		try {
			log.debug("UserInfo Get All Query is  : " + SELECT_ALL_USERINFO);			
			stmt = getConnection().createStatement();
			rSet = stmt.executeQuery(SELECT_ALL_USERINFO);
			List<UserInfo> lstRecords = new ArrayList<UserInfo>();
			if(rSet.next()) {
				do{
					UserInfo obj = new UserInfo();
					
					obj.setEmail(rSet.getString(EMAIL_COL));
					obj.setFirstName(rSet.getString(FIRSTNAME_COL));
					obj.setLastName(rSet.getString(LASTNAME_COL));
					obj.setMobileNo(rSet.getString(MOBILENO));
					obj.setUserId(rSet.getString(USER_ID_COL));
					
					lstRecords.add(obj);
					
				}while(rSet.next());
				log.debug("UserInfo records found from DB :" + lstRecords);
				return lstRecords;
				
			} else {
				log.debug("No Record Found while searching UserInfo records!" );
			}

		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for UserInfo Records.");
			e.printStackTrace();
		} finally {
			close(rSet);
			close(stmt);
		}
		
		return null;
	}
	

	@Override
	public UserInfo get() {
		
		PreparedStatement pStmt = null;
		ResultSet rSet = null;
		try {
			
			log.debug("UserInfo Get Query by email is : " + SELECT_USERINFO_BYEMAIL);
			pStmt = getConnection().prepareStatement(SELECT_USERINFO_BYEMAIL);
			pStmt.setString(1, this.getUserInfo().getEmail());
			
			rSet = pStmt.executeQuery();
			if (rSet.next()) {
				this.userInfo.setEmail(rSet.getString(EMAIL_COL));
				this.userInfo.setFirstName(rSet.getString(FIRSTNAME_COL));
				this.userInfo.setLastName(rSet.getString(LASTNAME_COL));
				this.userInfo.setMobileNo(rSet.getString(MOBILENO));
				this.userInfo.setUserId(rSet.getString(USER_ID_COL));
			}
			if(rSet.next()) {
				log.debug("Multiple records found for the User Info data, returing the first record result.Ignoring mutiple entries.");
			}
			log.debug("UserInfo object get() is : " + this.userInfo);
			return this.userInfo;
		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for UserInfo Records.");
			e.printStackTrace();
		} finally {
			
			close(rSet);
			close(pStmt);
		}
		
		return null;
	}
}
