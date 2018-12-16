<!DOCTYPE html>
<html>
<head>
    <title>memberMenu</title>
    <%@include file="head.jsp"%>
</head>
<body>

<%@include file="nav2.jsp"%>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <h2>Welcome to the Update Member Role Page!</h2>
            <br/>
            <h4>This page is use for updating Member role(s) in the system. Please enter the required fields below.
            </h4>
            <br/>
            <form name="updateForm" action="updateRoleServlet" onsubmit="return validateForm()" method="post">

                <div class="form-group">

                    <label for="username">Enter Username:</label>
                    <input type="email" class="form-control" id="username" name="username" required maxlength="40" size="40" placeholder="email address"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address">

                <br/>
                    <select class="custom-select custom-select-lg mb-3" name="role" required>
                        <option selected>member</option>
                        <option value="admin">admin</option>
                        <option value="register">register</option>
                    </select>

                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-primary">Reset</button>

            </form>
            <br/>

        </div>

        <div class="col-sm-6">
            <br/>

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>


