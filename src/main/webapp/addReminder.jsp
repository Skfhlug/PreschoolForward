<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/6/20
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<head>
    <title>Add Reminder</title>
</head>
<body>
<div class="background1">
<h1>Add Reminder</h1>

<form action="#" method="post">

    <label>Title:</label>
    <input type="text" name="reminder_title" class="form-control" placeholder="Title"/><br />

    <label>Description:</label>
    <input type="text" name="description" id="descriptionInput" class="form-control" placeholder="description"/><br />

    <label>Status:</label>
    <input type="text" name="username" class="form-control" /><br />

    <input type="submit" name="" value="Add New Admin" />
</form>
</div>
</body>
</html>
