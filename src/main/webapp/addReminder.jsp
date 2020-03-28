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
<div class="container-fluid">
<div class="background1">
<h1>Add Reminder</h1>
        <form action="addReminderServlet" method="POST">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" placeholder="Title" name="title">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="description" placeholder="Describe you reminder here" name="description">
            </div>
            <div class="form-group">
                <label>Display Status</label><br>
                <label><input type="radio" name="displayStatus" value="display">Display now</label><br>
                <label><input type="radio" name="displayStatus" value="none" checked>Not display</label>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>
</body>
</html>
