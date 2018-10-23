<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/20/2018
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<br/>
<h1>Family Member New Registration:</h1>

<form name="registrationForm"action="addMemberServlet"method="post">
<table width="100%">

<tr>
<td>

<table bgcolor="#E1E8F2"width="60%">
<tr>
<td>
<td>First Name:</td>
<td><input type="text"name="firstname"required pattern="[a-zA-Z0-9-]+"></td>
<td>MI:</td>
<td><input type="text"name="middlename"maxlength="4"size="2"></td>
<td>Last Name:</td>
<td><input type="text"name="lastname"required pattern="[a-zA-Z0-9-]+"></td>
</td>
<td>Birthdate:</td>
<td><input type="text"name="birthdate"maxlength="11"size="10"required pattern="\d{1,2}/\d{1,2}/\d{4}"Title="Date mm/dd/yyyy is required."></td>
</tr>
</table>

</td>
</tr>
<tr>
<td>
<table  bgcolor="#E1E8F2"width="60%">
<tr>
<td>Address:</td>
<td><input type="text"name="address"size="60"></td>
</tr>
</table>
<table bgcolor="#E1E8F2"width="60%">
<tr>
<td>City:</td>
<td><input type="text"name="city"width="2"></td>
<td>State:</td>
<td><input type="text"name="state"maxlength="2"size="2"></td>
<td>Zip Code:</td>
<td><input type="text"name="zipcode"></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table  bgcolor="#E1E8F2"width="100%">
<tr>
<td>Email:</td>
<td align="left"><input type="text"name="email"maxlength="45"size="45"required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"title="Invalid email address"></td>
<td>Phone:</td>
<td align="left"><input type="text"name="phone"></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table  bgcolor="#E1E8F2"width="60%">
<tr>
<td>
                                                        Password:
</td>
<td>
<input type="text"name="password"maxlength="30"size="30"required pattern=".{6,}"title="Password must be 6 characters or more!">

</td>
<td>
                                                        Confirm Password:
</td>
<td>
<input type="text"name="password"maxlength="30"size="30"required pattern=".{6,}"title="Password must be 6 characters or more!">

</td>
</tr>
</table>
</td>
</tr>
<tr>
<td align="center">
<input type="submit"value="Submit">
<input type="reset"value="Clear">
<input type="button"value="Go Back"onclick="history.back()">
</td>
</tr>

</table>
</form>

