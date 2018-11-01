<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/21/2018
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ include file="head-tag.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready(function(){
        $('#memberTable').DataTable();
    });
</script>

<html>
<body>

<div id="wrap" style="background-color:#c8d3c3">

    <%@ include file="header.jsp"%>

    <div class="container-fluid">
        <h2><div style="text-align: center;">Member Results Page:</div> </h2>
        <table id="memberTable" class="display" cellspacing="0" width="100%" border="1" bgcolor="#7fffd4">
            <table border="5px" class="col-lg12" style="margin:auto;width:80%;">
                <thead>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
                </thead>
                <body>
                <tr>
                    <td>${user.getFirstname()}</td>
                    <td>${user.getLastname()}</td>
                    <td>${user.getUsername()}</td>
                </tr>
                </body>
            </table>
        </table>
    </div>

    <%@ include file="footer-logout.jsp"%>

</div>
</body>
</html>

