<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
</div>
<a href = "addReminder.jsp"><button>Add Reminder</button></a>
<form action="reminder" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="Word"/><br />
    </div>
    <div class="form-group">
        <label>Type:</label>
        <input type="radio" name="searchType" value="id" checked> ID
        <input type="radio" name="searchType" value="reminder_title" > Title
        <input type="radio" name="searchType" value="description" > Description
        <input type="radio" name="searchType" value="admin"> admin Id
    </div>
    <input type="submit" name="" value="Search" />
</form>
<p>-------------------------------------------------------------------------------------------</p>

    <table class="ReminderTable">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>User ID</th>
                <th>User Username</th>
                <th>Display Status</th>
            </tr>

        <c:forEach var="reminder" items="${resultList}">
            <tr>
                <td>${reminder.id}</td>
                <td>${reminder.reminder_title}</td>
                <td>${reminder.description}</td>
                <td>${reminder.user.id}</td>
                <td>${reminder.user.username}</td>
                <td>${reminder.status}</td>
            </tr>
        </c:forEach>
        <c:forEach var="reminder" items="${reminders}">
            <tr>
                <td>${reminder.id}</td>
                <td>${reminder.reminder_title}</td>
                <td>${reminder.description}</td>
                <td>${reminder.user.id}</td>
                <td>${reminder.user.username}</td>
                <td>${reminder.status}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
