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
            <h2>Welcome to the Member Page!</h2>
            <br/>
            <h4>Click button below to view member profile or member events.</h4>
            <br/>
            <form name="searchMemberForm"action="searchMemberServlet"method="post">

                <tr>
                    <td align="center">
                        <button type="submit" name="submit" value="viewProfile" class="button">View Profile</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" name="submit" value="viewEvent" class="button">View Events</button>
                    </td>
                </tr>

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


