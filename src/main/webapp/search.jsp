<%@include file="head.jsp"%>
<html>
<body>
<h2>Family Contribution Search Page</h2>
<form action="searchUser" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search by Last Name</button>
    <button type="submit" name="submit" value="view/All" class="btn btn-primary">View all users</button>

</form>
</body>
</html>