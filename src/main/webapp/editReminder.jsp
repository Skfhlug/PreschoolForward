<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/114:43
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<head>
    <title>Edit Reminder</title>
</head>
<body>
<div class="container-fluid">
    <div class="background1">
        <h1>Edit Reminder</h1>

        <form action="editReminder" method="POST">
            <div class="form-group col-md-6">
                <!--<label>ID:</label>-->
                <input type="hidden" name="id" class="form-control" value="${reminder.id}" />
            </div>
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" value="${reminder.reminder_title}" name="title">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="description" value="${reminder.description}" name="description">
            </div>
            <div class="form-group">
                <label>Display Status</label><br>
                <label><input type="radio" name="displayStatus" value="display"
                <c:if test = "${reminder.status == 'display'}">
                              checked
                </c:if>>Display now</label><br>
                <label><input type="radio" name="displayStatus" value="none"
                <c:if test = "${reminder.status == 'none'}">
                              checked
                </c:if>>Not display</label>
            </div>
            <button type="submit">EDIT</button>
        </form>
    </div>
</div>

</body>
<%@include file="footer.jsp"%>
</html>
