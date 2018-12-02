<!DOCTYPE html>
<html>
<head>
    <title>memberMenu</title>
    <%@include file="head.jsp"%>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Family Hardship Contribution Website</a>
        </div>

        <ul class="nav navbar-nav navbar-right">

            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <h2>Welcome to the Search Member Page!</h2>
            <br/>
            <h4>This page is used for searching members in the system. No entry will search for all members.</h4>
            <br/>
            <form name="regForm" action="searchUserMemberServlet" onsubmit="return validateForm()" method="post">

                <div class="form-group">

                    <label for="username">Enter Username:</label>
                    <input type="email" class="form-control" id="username" name="username" maxlength="40" size="40" placeholder="email address"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address">

                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-primary">Reset</button>

            </form>

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


