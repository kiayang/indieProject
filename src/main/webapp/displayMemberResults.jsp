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
                <div class="col-sm-6">
                    <h2>Member Profile Page</h2>
                </div>

                <div class="col-sm-6">
                    <a href="addMember.jsp" class="btn btn-success">
                        <span>Add New Member</span></a>

                    <a href="#editMemberModal" class="btn btn-success" data-toggle="modal">
                        <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                </div>

            </div>
        </div>


    <table id="userTable" class="display " cellspacing="0" width="100%">
        <thead>
            <th>User Id</th>
            <th>User Name</th>
            <th>Status</th>
            <th>Full Name</th>
            <th>Middle Name</th>
            <th>Birthdate</th>
            <th>Address</th>
            <th>State</th>
            <th>Zip code</th>
            <th>Phone</th>
        </thead>
        <tbody>

        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getStatus()}</td>
            <td>${user.getFirstname()} ${user.getLastname()}</td>
            <td>${user.getMiddlename()}</td>
            <td>${user.getDateofbirth()}</td>
            <td>${user.getAddress()}</td>
            <td>${user.getState()}</td>
            <td>${user.getZipcode()}</td>
            <td>${user.getPhone()}</td>

        </tr>
        </tbody>
    </table>

        <!-- Edit Modal HTML -->
        <div id="editMemberModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form name="updateMemberForm"action="updateMemberServlet"method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Member</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">

                            <div class="form-group">
                                <label>User Id</label>
                                <input type="text" class="form-control" id="userid" name="userid" value="${user.getId()}" readonly>
                            </div>

                            <div class="form-group">
                                <input type="hidden" class="form-control" id="username" name="username" value="${user.getUsername()}" readonly>
                            </div>

                            <div class="form-group">
                                <label>User Status</label>
                                <input type="text" class="form-control" id="status" name="status" value="${user.getStatus()}" maxlength="10" readonly>
                            </div>

                            <div class="form-group">
                                <label>First name</label>
                                <input type="text" class="form-control" id="firstname" name="firstname" value="${user.getFirstname()}" maxlength="25" required>
                            </div>

                            <div class="form-group">
                                <label>Last name</label>
                                <input type="text" class="form-control" id="lastname" name="lastname" value="${user.getLastname()}" maxlength="35" required>
                            </div>

                            <div class="form-group">
                                <label>Middle name</label>
                                <input type="text" class="form-control" id="middlename" name="middlename" value="${user.getMiddlename()}" maxlength="10">
                            </div>

                            <div class="form-group">
                                <label>Date of Birth</label>
                                <input type="text" class="form-control" id="dateofbirth" name="dateofbirth" value="${user.getDateofbirth()}" maxlength="10" required pattern="\d{1,4}-\d{1,2}-\d{2}" required>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <input type="text" class="form-control" id="address" name="address" value="${user.getAddress()}" maxlength="35">
                            </div>

                            <div class="form-group">
                                <label>State</label>
                                <input type="text" class="form-control" id="state" name="state" value="${user.getState()}" maxlength="2">
                            </div>

                            <div class="form-group">
                                <label>Zip code</label>
                                <input type="text" class="form-control" id="zipcode" name="zipcode" value="${user.getZipcode()}" maxlength="12">
                            </div>

                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone" value="${user.getPhone()}" maxlength="12" required>
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input type="text" class="form-control" id="password" name="password" value="${user.getPassword()}" maxlength="20" required>
                            </div>

                        </div>

                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
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

