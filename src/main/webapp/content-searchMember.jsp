<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/21/2018
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<form name="regForm" action="searchMemberServlet" onsubmit="return validateForm()" method="post">
<table width="100%">


<tr>
<td colspan="2">
<br/>
        This page is used for searching members in the system. Please enter your email address. <br/><br/>
</td>
</tr>
<tr>
<td with="100%">
<table  bgcolor="#E1E8F2" width="100%">
<tr>
<td align="right" >Enter Email Address:</td>
<td align="left"><input type="text" name="username" maxlength="40" size="30"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address"></td>
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
