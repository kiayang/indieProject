<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="nav1.jsp"%>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <br/><br/>
            <FORM ACTION="j_security_check" METHOD="POST">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input TYPE="TEXT" class="form-control" NAME="j_username" maxlength="40" size="40" id="username" placeholder="enter email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="User ID must be an email address" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <INPUT TYPE="PASSWORD" class="form-control" NAME="j_password" ID="password" maxlength="15" maxsize="15" placeholder="enter password"required pattern=".{6,}" title="Password must be 6 characters or more!">
                </div>
                <button type="submit" value="login" class="btn btn-primary">Submit</button>
            </form>

        </div>

        <div class="col-sm-6">

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>


