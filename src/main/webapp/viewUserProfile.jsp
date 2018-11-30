<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head1.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>

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


<div class="container-fluid">

    <h2>Member Profile:</h2>

    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>User Name</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>MI</th>
        <th>Birthdate</th>
        <th>Address</th>
        <th>State</th>
        <th>Zip code</th>
        <th>Phone</th>
        <th>Password</th>
        </thead>
        <tbody>
        <tr>
            <td>${user.getUsername()}</td>
            <td>${user.getFirstname()}</td>
            <td>${user.getLastname()}</td>
            <td>${user.getMiddlename()}</td>
            <td>${user.getDateofbirth()}</td>
            <td>${user.getAddress()}</td>
            <td>${user.getState()}</td>
            <td>${user.getZipcode()}</td>
            <td>${user.getPhone()}</td>
            <td>${user.getPassword()}</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>

