<%--
  Created by IntelliJ IDEA.
  User: kia
  Date: 10/20/2018
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<form name="addMemberForm" action="addMemberServlet" onsubmit="return validateForm()" method="post">

<div class="row">
<div class="col-25">
<label for="firstname">First Name *</label>
</div>
<div class="col-75">
<input type="text" id="firstname" name="firstname" placeholder="Your name.." maxlength="25" size="50" required pattern="[a-zA-Z0-9-]+"/>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="lastname">Last Name *</label>
</div>
<div class="col-75">
<input type="text" id="lastname" name="lastname" placeholder="Your last name.." maxlength="35" size="50" required pattern="[a-zA-Z0-9-]+"/>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="middlename">Middle Name</label>
</div>
<div class="col-75">
<input type="text" id="middlename" name="middlename" maxlength="10" size="50"/>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="birthdate">Birthdate *</label>
</div>
<div class="col-75">
<input type="text" name="birthdate" id="birthdate" maxlength="10" size="50" required pattern="\d{1,4}-\d{1,2}-\d{2}" Title="Date yyyy-mm-dd is required."/>
</div></div>

<div class="row">
<div class="col-25">
<label for="address">Address</label>
</div>
<div class="col-75">
<input type="text" name="address" id="address" maxlength="35" size="50"/>
</div></div>

<div class="row">
<div class="col-25">
<label for="state">State</label>
</div>
<div class="col-75">
<input type="text" name="state" id="state" maxlength="2" size="50"/>
</div></div>

<div class="row">
<div class="col-25">
<label for="zipcode">Zip Code</label>
</div>
<div class="col-75">
<input type="text" name="zipcode" id="zipcode" maxlength="12" size="50"/>
</div></div>

<div class="row">
<div class="col-25">
<label for="phone">Phone</label>
</div>
<div class="col-75">
<input type="text" name="phone" id="phone" maxlength="12" size="50"/>
</div></div>

<div class="row">
<div class="col-25">
<label for="email">Email *</label>
</div>
<div class="col-75">
<input type="text" name="email" id="email" maxlength="40" size="50" required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid email address"/>
</div></div>

<div class="row">
<div class="col-25">
<label for="password">Password *</label>
</div>
<div class="col-75">
<input type="text" name="password" id="password" maxlength="20" size="50" required pattern=".{6,}" title="Password must be 6 characters or more!"/>
</div></div>

<div class="row">
<p>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</p>
</div>
</form>
