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

            <h2>Welcome to the Search Event Page!</h2>

            <br/>
            <h4>This page is use for searching events in the system. No entry will search for all events.</h4>
            <br/>

            <form name="searchForm" action="searchEventServlet" method="get">
                <div class="form-group">
                    <label for="searchTerm">Enter Search Term</label>
                    <input type="text" class="form-control" id="searchTerm" name="searchTerm" maxlength="100" size="40" placeholder="Enter Email or Event description name/keyword" aria-describedby="searchTermHelp">
                </div>

                <button type="submit" name="submit" value="username" class="btn btn-primary" >Search by Username</button>
                <button type="submit" name="submit" value="eventDescription" class="btn btn-primary">Search by Description</button>
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


