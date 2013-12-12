<%@page import="com.saloonsuite.dao.Authenticator"%>
<%
String strUserName = request.getParameter("username");
String strPwd = request.getParameter("password");
boolean isValid = Authenticator.isValid(strUserName,strPwd);

if(isValid) {
	session.setAttribute("loginName",strUserName);
	out.print("success");
} else {
	out.print("fail");
}
%>
