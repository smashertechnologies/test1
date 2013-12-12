<%@page import="com.saloonsuite.dao.UserInfoDAO"%>
<%@page import="com.saloonsuite.dao.UserInfoDAOImpl"%>
<%@page import="com.saloonsuite.data.entity.UserLogin"%>
<%@page import="com.saloonsuite.data.entity.UserInfo"%>
<%

String email = request.getParameter("email");
String strUserName = request.getParameter("newusername");

UserInfo info = new UserInfo();
info.setEmail(email);
UserLogin loginInfo = new UserLogin();
loginInfo.setUserName(strUserName);
info.setLoginInfo(loginInfo);

UserInfoDAO dao = new UserInfoDAOImpl();
dao.setUserInfo(info);

String isValid = ""+dao.exists();

out.println(isValid);
%>
