<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/20/2018
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <%@include file="head.jsp"%>
</head>
<body>

<%@include file="nav2.jsp"%>

<div class="container-fluid text-center">

    <div class="row content">

        <div class="col-sm-6 text-left">
            <br/><br/>
            <p class="bg-success"><bold>${returnMessage}</bold></p>
            <p class="bg-danger"><bold>${errorMessage}</bold></p>

        </div>

        <div class="col-sm-6">

            <img class="img-responsive" src="images/together.jpg" alt="quote" style="width:100%">

        </div>

    </div>
</div>


</body>
</html>


