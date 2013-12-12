
<%@page import="org.apache.log4j.Logger"%><%
	session.invalidate();
	Logger.getLogger(this.getClass()).debug("Session Invalidated.");
	out.println("Logout successful");
%>

