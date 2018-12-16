<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head1.jsp"%>

<script type="text/javascript" class="init">

    $(document).ready( function () {
        $('#userTable').DataTable();

        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

    });
</script>

<html>

<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Family Hardship Contribution Website</a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="displayAdminMenu.jsp"><span class="glyphicon glyphicon-home"></span> Admin Menu</a></li>
            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>


<div class="container-fluid">

    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-10">
                    <h2>Administrator <b>Manage Member Roles</b></h2>
                </div>
            </div>
        </div>


    <table id="userTable" class="display " cellspacing="0" width="100%">
        <thead>
            <th>Role Id</th>
            <th>User Name</th>
            <th>User Role</th>
            <th>Actions</th>
        </thead>
        <tbody>

            <c:forEach var="user" items="${roles}" varStatus="loop">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getUserRole()}</td>
                    <td>
                        <a href="#editRoleModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    </td>
                </tr>

            </c:forEach>

        </tbody>
    </table>

        <!-- Edit Modal HTML -->
        <div id="editRoleModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form name="updateMemberForm"action="updateRoleServlet"method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Member</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">

                            <div class="form-group">
                                <label>User name *</label>
                                <input type="email" class="form-control" id="username" name="username" placeholder="Enter required email address" maxlength="40" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address" required>
                            </div>

                            <div class="form-group">

                                <select class="custom-select custom-select-lg mb-3" name="role">
                                    <option selected>member</option>
                                    <option value="admin">admin</option>
                                    <option value="register">register</option>
                                </select>

                            </div>

                        </div>

                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="reset" class="btn btn-info" value="Reset">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>


</div>

    <div class="container-fluid">

        <div class="alert alert-success">
            <strong><bold>${returnMessage}</bold></strong>
            <strong><bold>${errorMessage}</bold></strong>
        </div>

    </div>

</div>
</body>
</html>

