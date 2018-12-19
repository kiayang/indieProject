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
            <h4>This page is used for searching members in the system. No entry will search for all members.</h4>
            <br/>
            <form name="regForm" action="adminSearchMemberServlet">

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


</body>
</html>


