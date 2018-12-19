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
                    <h2>Member Events Page</h2>
                </div>

                <div class="col-sm-4">

                    <c:if test="${userRole == 'admin'}">
                        <a href="adminAddEvent.jsp" class="btn btn-success">
                            <span>Add New Event</span></a>

                        <a href="#editEventModal" class="btn btn-success" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    </c:if>

                </div>
            </div>
        </div>

        <table id="userTable" class="display " cellspacing="0" width="100%">
            <thead>
            <th>User Event Id</th>
            <th>User Name Id</th>
            <th>Full Name</th>
            <th>Event Id</th>
            <th>Event Fee</th>
            <th>Event Date</th>
            <th>Paid Status</th>
            <th>Paid Date</th>
            <th>Event Description</th>
            </thead>
            <tbody>

            <c:forEach var="userevent" items="${userEvents}" varStatus="loop">
                <tr>
                    <td>${userevent.getUeId()}</td>
                    <td>${userevent.getUserBean().getUsername()}</td>
                    <td>${userevent.getUserBean().getFirstname()} ${userevent.getUserBean().getLastname()}</td>
                    <td>${userevent.getEventBean().getEventId()}</td>
                    <td>$${userevent.getEventBean().getEvent_fee()}</td>
                    <td>${userevent.getEventBean().getEvent_date()}</td>
                    <td>${userevent.getUePaidStatus()}</td>
                    <td>${userevent.getUePaidDate()}</td>
                    <td>${userevent.getEventBean().getDescription()}</td>

                </tr>

            </c:forEach>
            </tbody>
        </table>


        <!-- Edit Modal HTML -->
        <div id="editEventModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form name="updateMemberForm"action="updateUserEventServlet"method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Member</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">

                            <div class="form-group">
                                <label>Enter User Event Id *</label>
                                <input type="number" class="form-control" id="ue_id" name="ue_id" maxlength="11" required>
                            </div>

                            <div class="form-group">
                                <label>Select Paid Status *</label>
                                <select class="custom-select custom-select-lg mb-3" name="status">
                                    <option selected>paid</option>
                                    <option value="unpaid">unpaid</option>
                                </select>

                            </div>

                            <div class="form-group">
                                <label>Enter Paid Date</label>
                                <input type="text" class="form-control" id="date" name="date" required placeholder="format yyyy-mm-dd" maxlength="10" pattern="\d{1,4}-\d{1,2}-\d{1,2}">
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

