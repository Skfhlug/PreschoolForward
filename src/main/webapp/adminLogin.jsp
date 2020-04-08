<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/29/20
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<head>
    <title>Admin Login</title>
</head>
<body>
<h1>Admin Login</h1>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE class="login">
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>
</html>
