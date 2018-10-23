<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/21/2018
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<form name="regForm" action="searchEventServlet" method="post">
<table  bgcolor="#E1E8F2" width="100%">

<td colspan="2">
<br/>
        This page is used for searching members and associated events in the system. Please enter as many information as possible to limit the search. <br/>
        Leave the form blank will return all member events in the system. <br/> <br/>
</td>
</tr>
<tr>
<td with="80%">
<table  bgcolor="#E1E8F2" width="800">
<tr>
<td align="right" >Enter Event ID:</td>
<td align="left"><input type="text" name="eventid" maxlength="30" size="30" pattern="[0-9]" title="Numbers only"></td>
</tr>
<tr>
<td align="right" >Enter Event Name:</td>
<td align="left" ><input type="text" name="eventname"  maxlength="30" size="30"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Search">
<input type="reset" value="Reset">
<td>
</tr>
</table>
</td>

</tr>
</table>
</form>

