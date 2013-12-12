
<%@page import="com.saloonsuite.dao.UserInfoDAO"%>
<%@page import="com.saloonsuite.dao.UserInfoDAOImpl"%>
<%@page import="com.saloonsuite.data.entity.UserLogin"%>
<%@page import="com.saloonsuite.data.entity.UserInfo"%>
<%
try {
String firstName = request.getParameter("firstname");
String lastName = request.getParameter("lastname");
String mobileno = request.getParameter("mobileno");
String strUserName = request.getParameter("newusername");
String strEmail = request.getParameter("email");
String strPwd = request.getParameter("newpassword");
String strRePwd = request.getParameter("retypepassword");

UserInfo info = new UserInfo();
info.setEmail(strEmail);
info.setFirstName(firstName);
info.setLastName(lastName);
info.setMobileNo(mobileno);

UserLogin loginInfo = new UserLogin();
loginInfo.setActivated(0);
loginInfo.setResetPassword(0);
loginInfo.setUserName(strUserName);
loginInfo.setPassword(strPwd);
info.setLoginInfo(loginInfo);

UserInfoDAO dao = new UserInfoDAOImpl();
dao.setUserInfo(info);
boolean isSuccess = dao.create();
if ( isSuccess ) {
	session.setAttribute("loginName",strUserName);
	session.setAttribute("isActive","false");
	out.println("success");
} else {
	out.println("fail");
}
}
catch(Exception ex){
	out.println("fail");
}
%>
