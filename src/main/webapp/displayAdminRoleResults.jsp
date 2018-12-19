<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head1.jsp"%>

<html>

<body>

<%@include file="nav2.jsp"%>

<div class="container-fluid">

    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-8">
                    <h2>Administrator <b>Manage Member Roles</b></h2>
                </div>

                    <div class="col-sm-4">
                        <a href="addMember.jsp" class="btn btn-success">
                            <span>Add New Member</span></a>

                        <a href="#editRoleModal" class="btn btn-success" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    </div>
            </div>
        </div>


    <table id="userTable" class="display " cellspacing="0" width="100%">
        <thead>
            <th>Role Id</th>
            <th>User Name</th>
            <th>User Role</th>
        </thead>
        <tbody>

            <c:forEach var="user" items="${roles}" varStatus="loop">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getUserRole()}</td>

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
                                <label>Enter Role Id *</label>
                                <input type="number" class="form-control" id="number" name="roleid" placeholder="Enter Rold Id" maxlength="11" required>
                            </div>

                            <div class="form-group">
                                <label>Select User Role *</label>
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

