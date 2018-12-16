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

        <ul class="nav navbar-nav navbar-right">
            <li><a href="addMember.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="displayAdminMenu.jsp"><span class="glyphicon glyphicon-user"></span> Admin Login</a></li>
            <li><a href="displayMemberMenu.jsp"><span class="glyphicon glyphicon-log-in"></span> Member Login</a></li>
        </ul>
    </div>
</nav>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <br/><br/>
            <p class="bg-success"><bold>${returnMessage}</bold></p>
            <p class="bg-danger"><bold>${errorMessage}</bold></p>

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


