<%@include file="head.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
    <meta name="dcterms.created" content="Tue, 02 Oct 2018 00:49:25 GMT">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>Family Hardship Contribution</title>

    <style type="text/css">
        <!--
        body {
            color:#000000;
            background-color:#FFFFFF;
            background-image:url('Background Image');
            background-repeat:no-repeat;
        }
        a  { color:#0000FF; }
        a:visited { color:#800080; }
        a:hover { color:#008000; }
        a:active { color:#FF0000; }
        -->
    </style>
    <!--[if IE]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<form name="regForm" action="searchMember" >
    <table width="1100">
        <tr bgcolor="#54AAFF">
            <td colspan="2">
                <span style="font-size: x-large; ">Navigation Filler</span>
            </td>
        </tr>
        <tr bgcolor="#BFEBFF">
            <td colspan="2">
                <span style="font-size: x-large; ">Member Search</span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <br/>
                This page is used for searching members in the system. Please enter as member information as possible to limit the search. <br/>
                Leave the form blank will return all members in the system. <br/> <br/>
            </td>
        </tr>
        <tr>
            <td with="80%">
                <table  bgcolor="#F7EFFF" width="800">
                    <tr>
                        <td align="right" >Enter MemberID:</td>
                        <td align="left"><input type="text" name="memberid" maxlength="10" size="30"></td>
                    </tr>
                    <tr>
                        <td align="right" >Enter First Name:</td>
                        <td align="left" ><input type="text" name="firstname"  maxlength="25" size="30"></td>
                    </tr>
                    <tr>
                        <td align="right" >Enter First Name:</td>
                        <td align="left"><input type="text" name="lastname" maxlength="35" size="30"></td>
                    </tr>
                    <tr>
                        <td align="right" >Enter Email:</td>
                        <td align="left" ><input type="text" name="email"  maxlength="30" size="30"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Search">
                            <input type="reset" value="Reset">
                        <td>
                    </tr>
                </table>
            </td>
            <td align="left" bgcolor="#99B6FF" width="20%">
                <table>
                    <tr>
                        <td>
                            <span>&nbsp&nbsp&nbsp&nbsp&nbsp Active Events</span>
                            <ol>
                                <li><a href>Event 1 -- $15</a></li>
                                <li><a href>Event 2 -- $15</a></li>
                                <li><a href>Event 3 -- $15</a></li>
                            </ol>
                        </td>
                    </tr>
                </table>

            </td>
        </tr>
    </table>
</form>
</body>
</html>



