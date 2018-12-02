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

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Family Hardship Contribution Website</a>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">

    <div class="row content">

        <%@ page session="true"%>

        <div class="col-sm-6 text-left">
            <br/><br/>
            <p class="bg-danger"><bold>Error! User not allowed to login due to security!</bold></p>
        </div>

        <% session.invalidate(); %>

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


