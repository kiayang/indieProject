</html><!DOCTYPE html>
<html>
<head>
    <title>memberMenu</title>
    <%@include file="head.jsp"%>
</head>
<body>

<%@include file="nav2.jsp"%>

<div class="container">
    <div class="row" text="center">
        <h2>Welcome to the Add/Register New Member Page!</h2>
        <h4>This page is use to add/register new member, please enter member information below. All * fields are required.</h4>
    </div>
    <br/>

</div>

<div class="container">

    <form name="addMemberForm" action="addMemberServlet" onsubmit="return validateForm()" method="post">

        <div class="row">
            <div class="col-25">
                <label for="firstname">Enter First Name *</label>
            </div>
            <div class="col-75" style="">
                <input type="text" id="firstname" name="firstname" placeholder="Your name.." maxlength="25" size="40" required pattern="[a-zA-Z0-9-]+"/>
            </div>
        </div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="lastname">Enter Last Name *</label>
            </div>
            <div class="col-75">
                <input type="text" id="lastname" name="lastname" placeholder="Your last name.." maxlength="35" size="40" required pattern="[a-zA-Z0-9-]+"/>
            </div>
        </div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="middlename">Enter Middle Name</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" id="middlename" name="middlename" maxlength="10" size="40"/>
            </div>
        </div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="birthdate">Enter Birthdate *</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="birthdate" id="birthdate" maxlength="10" size="40" required pattern="\d{1,4}-\d{1,2}-\d{2}" Title="Date yyyy-mm-dd is required."/>
            </div></div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="address">Enter Address</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="address" id="address" maxlength="35" size="40"/>
            </div></div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="state">Enter State</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="state" id="state" maxlength="2" size="40"/>
            </div></div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="zipcode">Enter Zip Code</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="zipcode" id="zipcode" maxlength="12" size="40"/>
            </div></div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="phone">Enter Phone</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="phone" id="phone" maxlength="12" size="40"/>
            </div></div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="email">Enter Email *</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="email" id="email" maxlength="40" size="40" required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address"/>
            </div></div>

        <br/>
        <div class="row">
            <div class="col-25">
                <label for="password">Enter Password *</label>
            </div>
            <div class="col-75">
                <input class="form-control" type="text" name="password" id="password" maxlength="20" size="40" required pattern=".{6,}" title="Password must be 6 characters or more!"/>
            </div></div>

        <br/>
        <div class="row">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-primary">Reset</button>
        </div>

    </form>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>





