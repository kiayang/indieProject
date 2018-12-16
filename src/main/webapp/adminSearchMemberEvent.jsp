<!DOCTYPE html>
<html>
<head>
    <title>memberMenu</title>
    <%@include file="head.jsp"%>
</head>
<body>

<%@include file="nav2.jsp"%>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <h2>Welcome to the Search Member Page!</h2>
            <br/>
            <h4>This page is use for searching Member(s) and associated Event(s) in the system. More than one criteria can be entered to limit search.
                No entry will search for all Members and associated Events.</h4>
            <br/>
            <form name="searchForm" action="searchEventServlet" onsubmit="return validateForm()" method="post">

                <div class="form-group">

                    <label for="username">Enter Username:</label>
                    <input type="email" class="form-control" id="username" name="username" maxlength="40" size="40" placeholder="email address"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address">

                    <label for="eventId">Enter Event Id:</label>
                    <input class="form-control" type="text" id="eventId" name="eventId" maxlength="11" size="40" pattern="[0-9]" title="Numbers only">

                    <label for="eventDate">Enter Event Date:</label>
                    <input class="form-control" type="text" id="eventDate" name="eventDate" maxlength="10" size="40" pattern="\d{1,4}-\d{1,2}-\d{2}" Title="Date yyyy-mm-dd is required." placeholder="YYYY-MM-DD">

                    <label for="eventName">Enter Event Name/Description:</label>
                    <input class="form-control" type="text" id="eventName" name="eventName" maxlength="40" size="40" placeholder="Enter event description name or keyword">

                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-primary">Reset</button>

            </form>
            <br/>

        </div>

        <div class="col-sm-6">
            <br/>

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>


