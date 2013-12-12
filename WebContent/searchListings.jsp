<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.saloonsuite.data.entity.CustomerInfo"%>
<%@page import="java.util.Collections"%>
<%@page import="com.saloonsuite.dao.CustomerInfoDAOImpl"%>
<%@page import="com.saloonsuite.util.validator.BaseValidator"%>
<%@page import="com.saloonsuite.data.entity.CustomerServices"%>
<%
String names = request.getParameter("names");
String services = request.getParameter("services");
String places = request.getParameter("places");
Logger.getLogger(this.getClass()).debug("Names :" + names);
Logger.getLogger(this.getClass()).debug("Services :" + services);
Logger.getLogger(this.getClass()).debug("Places :" + places);

List<CustomerInfo> lstObjects = new CustomerInfoDAOImpl().getAll(names,services,places);


%>



<%@page import="org.apache.log4j.Logger"%><ol id="searchresultlist">
<%for(CustomerInfo info : lstObjects ) {
%>

	<li>
		<table border="0" width="100%">
		<colspan>
			<col width="500px"/>
		</colspan>
		<tr>
			<td valign="top">
				<table width="100%">
					<tr>
						<td class="listTitle"><%=info.getTitle() %></td></tr>
						<tr>
							<td class="listAddress">
								<%=info.getAddress().displayString() %>
							</td>
						</tr>
						<tr><td> 
								<ul  id="listServices" class="listServices">
								<%for(CustomerServices cServices:info.getServices()){ %>
									<li><%=cServices.getServiceName() %></li>
								<%} %>
									
								</ul>
						</td></tr>
				</table>
			</td>
			<td align="center">
				<table>
				<tr>
				<td colspan="2">
					<img src="images/<%=info.getImageName() %>" height="200"/><br/>
				</td>
				</tr>
				<tr>
				<td align="center" valign="middle"><img src="images/up.png" height="25" width="25"/><br><%=info.getUps() %></td>
				<td align="center"><img src="images/down.png" height="25" width="25"/><br><%=info.getDowns() %></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<hr/>
	</li>
<%} %>
</ol>
			
