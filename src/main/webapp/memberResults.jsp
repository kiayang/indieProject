<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready(function(){
        $('#memberTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="memberTable" class="display" cellspacing="0" width="100%" border="1" bgcolor="#7fffd4">
        <thead>
        <th>Name</th>
        <th>User</th>
        <th>Age</th>
        </thead>
        <tbody>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
