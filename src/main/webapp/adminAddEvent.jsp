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
            <h2>Welcome to the Add Event Page!</h2>
            <br/>
            <h4>This page is use to add a new event, please enter event information below. All * fields are required.</h4>
            <br/>
            <form name="searchForm" action="addEventServlet" onsubmit="return validateForm()" method="post">

                <div class="form-group">

                    <label for="username">Enter Username *</label>
                    <input class="form-control" type="text" name="username" id="username" maxlength="40" size="40" required  placeholder="Enter email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address"/>

                    <label for="eventDate">Enter Event Date *</label>
                    <input class="form-control" type="text" name="eventDate" id="eventDate" required pattern="\d{1,4}-\d{1,2}-\d{2}" Title="Date yyyy-mm-dd is required." placeholder="YYYY-MM-DD">

                    <label for="eventFee">Enter Event Fee *</label>
                    <input class="form-control" name="eventFee" id="eventFee" type="text" required pattern="^\d*(\.\d{2}$)?" size="4"
                            title="CDA Currency Format - no dollar sign and no comma(s) - cents (.##) are optional"
                            placeholder="Enter amount, no dollar sign and no comma(s) - cents (.##) are optional "/>

                    <label for="eventDescription">Enter Event Name/Description:</label>
                    <input class="form-control" type="text" name="eventDescription" id="eventDescription" maxlength="100" size="40">

                </div>

                <button type="reset" class="btn btn-primary">Reset</button>
                <button type="submit" class="btn btn-primary">Submit</button>

            </form>

        </div>

        <div class="col-sm-6">

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>


</body>
</html>


