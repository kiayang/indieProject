<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>

<body>
<div id="wrap" style="background-color:#c8d3c3">

    <%@ include file="header.jsp"%>

    <div class="container-fluid">
        <h2><div style="text-align: center;">User Profile:</div> </h2>

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

    <%@ include file="footer-logout.jsp"%>

</div>
</body>
</html>

