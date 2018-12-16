<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/23/2018
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>


<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="nav1.jsp"%>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">

            <%@ page session="true"%>
            <br/><br/>
            <p class="bg-warning"><bold>User '<%=request.getRemoteUser()%>' has been logged out.</bold></p>

            <% session.invalidate(); %>

        </div>

        <div class="col-sm-6">

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>


