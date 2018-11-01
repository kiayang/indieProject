<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/20/2018
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<form name="regForm" action="addMemberServlet" onsubmit="return validateForm()" method="post">

<fieldset id="memberInfo">
<legend>Member Information</legend>

    <label for="firstname">First Name *</label>
    <input name="firstname" id="firstname" maxlength="25" size="50" required pattern="[a-zA-Z0-9-]+"/>

    <label for="lastname">Last Name *</label>
    <input name="lastname" id="lastname" maxlength="35" size="50" required pattern="[a-zA-Z0-9-]+"/>

    <label for="middlename">Middle Name</label>
    <input name="middlename" id="middlename" maxlength="10" size="50"/>

    <label for="birthdate">Birthdate *</label>
    <input name="birthdate" id="birthdate" maxlength="10" size="50" required pattern="\d{1,4}-\d{1,2}-\d{2}" Title="Date yyyy-mm-dd is required."/>

    <label for="address">Address</label>
    <input name="address" id="address" maxlength="35" size="50"/>

    <label for="state">State</label>
    <input name="state" id="state" maxlength="2" size="50"/>

    <label for="zipcode">Zip Code</label>
    <input name="zipcode" id="zipcode" maxlength="12" size="50"/>

    <label for="phone">Phone</label>
    <input name="phone" id="phone" maxlength="12" size="50"/>

    <label for="email">Email *</label>
    <input name="email" id="email" maxlength="40" size="50" required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address"/>

    <label for="password">Password *</label>
    <input name="password" id="password" maxlength="20" size="50" required pattern=".{6,}" title="Password must be 6 characters or more!"/>

</fieldset>

<p>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</p>

</form>
