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
                    <h2>Administrator <b>Manage Events</b></h2>
                </div>

                <div class="col-sm-4">
                    <a href="adminAddEvent.jsp" class="btn btn-success">
                        <span>Add New Event</span></a>

                    <a href="#deleteEventModal" class="btn btn-success" data-toggle="modal">
                        <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                </div>

            </div>
        </div>


    <table id="userTable" class="display " cellspacing="0" width="100%">
        <thead>
            <th>Event ID</th>
            <th>User Name</th>
            <th>Description</th>
            <th>Event Date</th>
            <th>Event Fee</th>
        </thead>
        <tbody>

            <c:forEach var="event" items="${events}" varStatus="loop">
                <tr>

                    <td>${event.getEventId()}</td>
                    <td>${event.getEvent_userid()}</td>
                    <td>${event.getDescription()}</td>
                    <td>${event.getEvent_date()}</td>
                    <td>${event.getEvent_fee()}</td>

                </tr>

            </c:forEach>

        </tbody>
    </table>

        <!-- Delete Modal HTML -->
        <div id="deleteEventModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form name="deleteEventForm"action="deleteEventServlet"method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Delete Event</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete this Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>

                            <div class="form-group">
                                <label>Enter User Event Id *</label>
                                <input type="number" class="form-control" id="eventid" name="eventid" maxlength="11" required>
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

