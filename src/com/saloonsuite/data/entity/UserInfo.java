package com.saloonsuite.data.entity;

import static com.saloonsuite.util.UserInfoConstants.EMAIL_COL;
import static com.saloonsuite.util.UserInfoConstants.FIRSTNAME_COL;
import static com.saloonsuite.util.UserInfoConstants.LASTNAME_COL;
import static com.saloonsuite.util.UserInfoConstants.MOBILENO;
import static com.saloonsuite.util.UserInfoConstants.USER_ID_COL;
import static com.saloonsuite.util.validator.BaseValidator.isNullOrBlank;
public class UserInfo extends DataObject{
	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private UserLogin _loginInfo;
	
	public void setLoginInfo(UserLogin loginInfo) {
		this._loginInfo = loginInfo;
	}
	public UserLogin getLoginInfo() {
		return this._loginInfo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String toString() {
		return "UserId = " + userId + "," +"FirstName = " + firstName + "," + "LastName = " + lastName +"," + "EMail = " + email
		+","+"MoibileNo = " + mobileNo;
	}
	@Override
	public String getQueryString() {

		StringBuffer strQueryBuffer = new StringBuffer();
		boolean isFirst = true;
		if (!isNullOrBlank(""+userId)) {
			strQueryBuffer.append(USER_ID_COL + "=" + userId+"");
			isFirst = false;
		}
		if (!isNullOrBlank(firstName)) {
			
			if(!isFirst)
				strQueryBuffer.append(" and ");
			strQueryBuffer.append(FIRSTNAME_COL + "='" + firstName+"'");
			isFirst = false;
		}
		if (!isNullOrBlank(lastName)) {
			if(!isFirst)
				strQueryBuffer.append(" and ");
			strQueryBuffer.append(LASTNAME_COL + "='" + lastName+"'");
			isFirst = false;
		}
		if (!isNullOrBlank(email)) {
			if(!isFirst)
				strQueryBuffer.append(" and ");

			strQueryBuffer.append(EMAIL_COL + "='" + email+"'");
			isFirst = false;
		}
		if (!isNullOrBlank(mobileNo)) {
			if(!isFirst)
				strQueryBuffer.append(" and ");

			strQueryBuffer.append(MOBILENO + "='" + mobileNo+"'");
		}
		return strQueryBuffer.toString();
	}
	
}
