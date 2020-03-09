<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/20
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<body>
<div class="background1">
<h1>Add User</h1>

    <form action="addUserServlet" method="POST">
        <label>First Name:</label>
        <input type="text" name="first_name" class="form-control" placeholder="First name"/><br />

        <label>Last Name:</label>
        <input type="text" name="last_name" class="form-control" placeholder="Last Name"/><br />

        <label>username:</label>
        <input type="text" name="last_name" class="form-control" placeholder="username"/><br />

        <label>password:</label>
        <input type="password" name="password" class="form-control" placeholder="password"/><br />

        <label>email:</label>
        <input type="text" name="email" class="form-control" placeholder="email"/><br />

        <label>phone:</label>
        <input type="text" name="phone" class="form-control" placeholder="phone"/><br />

        <input type="submit" name="" value="Add New User" />
    </form>
</div>
</body>
</html>
