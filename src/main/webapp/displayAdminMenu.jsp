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
            <li><a href="displayMemberMenu.jsp"><span class="glyphicon glyphicon-home"></span> Member Menu</a></li>
            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>

</nav>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <h2>Welcome to the Admin Page!</h2>
            <br/>

            <table  bgcolor="#E1E8F2" width="100%">
                <tr>
                    <td>
                        <a href="adminSearchMember.jsp" class="button">Search Member</a>
                    </td>
                </tr>

                <tr>
                    <td>
                        <a href="adminSearchRole.jsp" class="button">Search Member Role</a>
                    </td>
                </tr>

                <tr>
                    <td>
                        <a href="adminSearchMemberEvent.jsp" class="button">Search Member Event</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="adminSearchEvent.jsp" class="button">Search Event</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="adminAddEvent.jsp" class="button">Add Event</a>
                    </td>
                </tr>
                
            </table>

        </div>

        <div class="col-sm-6">

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>


</body>
</html>


