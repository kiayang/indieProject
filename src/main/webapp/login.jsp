<%@include file="head.jsp"%>
<!DOCTYPE html>
<body>

<table width="1100">
    <tr bgcolor="#0E97FF">
        <td colspan="2">
            <span style="font-size: x-large; ">Navigation Filler</span>
        </td>
    </tr>
    <tr bgcolor="#BFEBFF">
        <td colspan="2">
            <span style="font-size: x-large; ">Welcome to Family Hardship Contribution Home</span>
        </td>
    </tr>
    <tr>
        <td with="80%">
            <table  bgcolor="#F7EFFF" width="100%">
                <tr>
                    <form name="loginForm" action="/login"  method="post">
                        <td align>
                            User ID:
                            <input type="text" name="username" maxlength="30" size="30" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="User ID must be an email address" required>
                            Password:
                            <input type="text" name="password" required pattern=".{6,}" title="Password must be 6 characters or more!">
                            <input type="submit" value="Login" >
                        </td>
                    </form>
                </tr>
                <tr>
                    <form name="registerForm" action="/registerMemberServlet" method="post">
                        <td colspan="5" align="left"  bgcolor="#F7EFFF">
                            <br/>
                            Not a member? <input type="submit" value="New Register">
                            <br/>
                        </td>
                    </form>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            When times are hard we as families will come together and help each other out in our time of need. Those who are member
            of this family are mendatory obligated to contribute to each hardship event that are being listed on the right side. The pay your
            dues please click on each event and pay.
        </td>
    </tr>
</table>
</form>
</body>
</html>



