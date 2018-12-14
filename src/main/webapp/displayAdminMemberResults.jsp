<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head1.jsp"%>

<script type="text/javascript" class="init">

    $(document).ready( function () {
        $('#userTable').DataTable();

        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function(){
            if(this.checked){
                checkbox.each(function(){
                    this.checked = true;
                });
            } else{
                checkbox.each(function(){
                    this.checked = false;
                });
            }
        });
        checkbox.click(function(){
            if(!this.checked){
                $("#selectAll").prop("checked", false);
            }
        });
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
                    <h2>Administrator <b>Manage Members</b></h2>
                </div>

                <div class="col-sm-2">
                    <a href="addMember.jsp" class="btn btn-success">
                        <span>Add New Member</span></a>
                </div>
            </div>
        </div>


    <table id="userTable" class="display " cellspacing="0" width="100%">
        <thead>
            <th>User Name</th>
            <th>status</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>MI</th>
            <th>Birthdate</th>
            <th>Address</th>
            <th>State</th>
            <th>Zip code</th>
            <th>Phone</th>
            <th>Actions</th>
        </thead>
        <tbody>

            <c:forEach var="user" items="${users}" varStatus="loop">
                <tr>
                    <td>${user.getUsername()}</td>
                    <td>${user.getStatus()}</td>
                    <td>${user.getFirstname()}</td>
                    <td>${user.getLastname()}</td>
                    <td>${user.getMiddlename()}</td>
                    <td>${user.getDateofbirth()}</td>
                    <td>${user.getAddress()}</td>
                    <td>${user.getState()}</td>
                    <td>${user.getZipcode()}</td>
                    <td>${user.getPhone()}</td>
                    <td>
                        <a href="#editMemberModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="#deleteMemberModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                </tr>

            </c:forEach>

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
                                <label>User name *</label>
                                <input type="email" class="form-control" id="username" name="username" placeholder="Enter required email address" maxlength="40" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address" required>
                            </div>

                            <div class="form-group">

                                <select class="custom-select custom-select-lg mb-3" name="status">
                                    <option selected>active</option>
                                    <option value="inactive">inactive</option>
                                    <option value="new">new</option>
                                </select>

                            </div>

                            <div class="form-group">
                                <label>First name</label>
                                <input type="text" class="form-control" id="firstname" name="firstname" maxlength="25">
                            </div>

                            <div class="form-group">
                                <label>Last name</label>
                                <input type="text" class="form-control" id="lastname" name="lastname" maxlength="35">
                            </div>

                            <div class="form-group">
                                <label>Middle name</label>
                                <input type="text" class="form-control" id="middlename" name="middlename" maxlength="10">
                            </div>

                            <div class="form-group">
                                <label>Date of Birth</label>
                                <input type="text" class="form-control" id="dateofbirth" name="dateofbirth" value="9999-12-31" maxlength="10" pattern="\d{1,4}-\d{1,2}-\d{1,2}">
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <input type="text" class="form-control" id="address" name="address" maxlength="35">
                            </div>

                            <div class="form-group">
                                <label>State</label>
                                <input type="text" class="form-control" id="state" name="state" maxlength="2">
                            </div>

                            <div class="form-group">
                                <label>Zip code</label>
                                <input type="text" class="form-control" id="zipcode" name="zipcode" maxlength="12">
                            </div>

                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone" maxlength="12">
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input type="text" class="form-control" id="password" name="password" maxlength="20">
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

        <!-- Delete Modal HTML -->
        <div id="deleteMemberModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form name="deleteMemberForm"action="deleteMemberServlet"method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Delete Member</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete this Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>

                            <div class="form-group">
                                <label>Enter User name:</label>
                                <input type="email" class="form-control" id="username" name="username" maxlength="40" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address" required>
                            </div>

                        </div>
                        <div class="modal-footer">

                            <div>
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-danger" value="Delete">
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

</div>
</div>
</body>
</html>

