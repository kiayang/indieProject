<br/><br/>
<h1>Family Member Login:</h1>

<form name="loginForm" action="/loginServlet"  method="post">

<table cellspaceing="5" border="0">
<tr>
<td align="left">User ID: </td>
<td><input type="text" name="userid" maxlength="40" size="40" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="User ID must be an email address" required>
<td/>
</tr>

<tr>
<td align="left">Password: </td>
<td><input type="text" name="password" maxlength="15" maxsize="15" required pattern=".{6,}" title="Password must be 6 characters or more!">
<input type="submit" value="login"style="font-size:15pt;color:white;background-color:green;border:4px solid #336600;padding:4px">
</td>
<tr/>

<br/><br/>

</table>
</form>


<form name="addMemberForm" action="/addMember" method="post">
<table cellspaceing="5" border="0">

<br/><br/>
<td colspan="5" align="left">

<br/>
        Not a member? <input type="submit" value="New Register" style="font-size:15pt;color:white;background-color:green;border:4px solid #336600;padding:4px">

<br/>
</td>
</table>
</form>
