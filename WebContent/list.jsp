<%@page import="java.util.ArrayList"%>
<%@page import="com.saloonsuite.data.entity.CustomerAddress"%>
<%@page import="com.saloonsuite.data.entity.CustomerInfo"%>
<%@page import="com.saloonsuite.dao.CustomerInfoDAOImpl"%><%@page import="com.saloonsuite.data.entity.Services"%>
<%@page import="com.saloonsuite.dao.ServicesDAOImpl"%>
<%@page import="com.saloonsuite.data.entity.CustomerServices"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json" language="java" errorPage="" %>
<%
	response.setContentType("application/json");
	response.setHeader("Content-Disposition", "inline");
	String strTypeParameter = (String) request.getParameter("data");
	ServicesDAOImpl dao = new ServicesDAOImpl();
	List<Services> lstServices = dao.getAll();
	CustomerInfoDAOImpl cDAO = new CustomerInfoDAOImpl();
	List<CustomerInfo> lstCustomers = cDAO.getAll();
	List<CustomerAddress> lstCustomerAddress = new ArrayList<CustomerAddress>();
	for(CustomerInfo i : lstCustomers) {
		lstCustomerAddress.add(i.getAddress());
	}
%>

<% if ( "names".equalsIgnoreCase(strTypeParameter)) {%>
[
	<%int indx =0;%>
	<%for (CustomerInfo cInfo : lstCustomers) { indx ++;%>
    	{"value":"<%=cInfo.getTitle()%>"}<%if ( indx < lstCustomers.size()){%>,<%}%>
    <%}%>
]
<%} else if ( "services".equalsIgnoreCase(strTypeParameter)) {%>
[
	<%int indx =0;%>
	<%for (Services s : lstServices) { indx ++;%>
    	{"value":"<%=s.getServiceName()%>"}<%if ( indx < lstServices.size()){%>,<%}%>
    <%}%>
]
<%}else if ( "places".equalsIgnoreCase(strTypeParameter)) {%>
[
	<%int indx =0;%>
	<%for (CustomerAddress cAdd : lstCustomerAddress) { indx ++;%>
    	{"value":"<%=cAdd.getCity()%>"}<%if ( indx < lstCustomerAddress.size()){%>,<%}%>
    <%}%>
]
<%}%>
