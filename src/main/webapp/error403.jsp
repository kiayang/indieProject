<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/20/2018
  Time: 7:37 PM
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

        <%@ page session="true"%>

        <div class="col-sm-6 text-left">
            <br/><br/>
                <p class="bg-danger"><bold>Error 403 - User FORBIDDEN to access the page due to security! User has been logged out!</bold></p>
        </div>

        <% session.invalidate(); %>

        <div class="col-sm-6">

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>


</body>
</html>


