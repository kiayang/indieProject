<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/22/2018
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<form name="regForm" action="/addEventServlet" method="post">
<table  bgcolor="#E1E8F2" width="100%">
<tr>
<td align>
                                Event Name: <input type="text" name="eventname" maxlength="30" size="30" required> <br/>
</td>
</tr>
<tr>
<td>
                                Event Date: <input type="text" name="eventdate" required pattern="\d{1,2}/\d{1,2}/\d{4}" Title="Date mm/dd/yyyy is required."><br/>
</td>
</tr>
<tr>
<td>
                                Amount Due: <input type="text" name="amount" required pattern="[0-9]" title="Numbers only"><br/>

<br/>
<tr>
<td align="center">
<input type="submit" value="Add Event">
</td>
</tr>

</table>
</form>
