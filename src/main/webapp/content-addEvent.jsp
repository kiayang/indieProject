<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/22/2018
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>

<form name="eventForm" action="addEventServlet"  method="post">
<div style="background-color:9CBDC0;color:black;padding:15px;">
        To add a new event, please enter event information below: <br/> <br/>
        Event Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="eventname" maxlength="100" size="100" required> <br/><br/>

        Event Date: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="eventdate" required pattern="\d{1,2}/\d{1,2}/\d{4}" Title="Date mm/dd/yyyy is required."><br/><br/>

        Amount Due: &nbsp;&nbsp;&nbsp;<input type="text" name="amount" required pattern="[0-9]" title="Numbers only"><br/><br/>

        &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
<input type="submit" value="Submit">  &nbsp;&nbsp; <input type="reset" value="Clear">
</div>
</form>
