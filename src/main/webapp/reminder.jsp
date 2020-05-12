<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
</div>
<a href = "addReminder.jsp"><button>Add Reminder</button></a>
<form action="reminder" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="Enter Searching key here" /><br />
    </div>
    <div class="form-group">
        <label>Type:</label>
        <input type="radio" name="searchType" value="id" checked> ID
        <input type="radio" name="searchType" value="reminder_title" > Title
        <input type="radio" name="searchType" value="description" > Description
        <input type="radio" name="searchType" value="admin"> admin Id
    </div>
    <input type="submit" name="" value="Search" /><button type="submit" name="submit" value="viewAll">View All</button>
</form>
<p>-------------------------------------------------------------------------------------------</p>

    <table class="ReminderTable">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>User Username</th>
                <th>Display Status</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

        <c:forEach var="reminder" items="${resultList}">
            <tr>
                <td>${reminder.id}</td>
                <td>${reminder.reminder_title}</td>
                <td>${reminder.description}</td>

                <td>${reminder.user.username}</td>
                <td>${reminder.status}</td>
                <td><a  href="editReminder?editID=${reminder.id}">edit</a></td>
                <td><a  href="deleteReminder?deleteID=${reminder.id}">delete</a></td>
            </tr>
        </c:forEach>
        <c:forEach var="reminder" items="${reminders}">
            <tr>
                <td>${reminder.id}</td>
                <td>${reminder.reminder_title}</td>
                <td>${reminder.description}</td>
                <td>${reminder.user.username}</td>
                <td>${reminder.status}</td>
                <td><a  href="editReminder?editID=${reminder.id}">edit</a></td>
                <td><a  href="deleteReminder?deleteID=${reminder.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
<%@include file="footer.jsp"%>
</html>
