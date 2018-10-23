<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/23/2018
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true"%>

User '<%=request.getRemoteUser()%>' has been logged out.

<% session.invalidate(); %>

<br/><br/>
<a href="index.jsp">Click here to go to home page</a>

