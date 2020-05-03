<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/29/20
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<head>
    <title>Student</title>
</head>
<body>
<h2>Student</h2> <a href="addUser.jsp"><button>Add Student</button></a>
<form action="searchStudent" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="Enter Searching key here" />
    </div>
    <div class="form-group">
        <label>Type:</label>
        <input type="radio" name="searchType" value="id" checked> ID &nbsp;
        <input type="radio" name="searchType" value="first_name" > First Name &nbsp;
        <input type="radio" name="searchType" value="last_name"> Last Name &nbsp;
        <input type="radio" name="searchType" value="grade" > Grade&nbsp;
        <input type="radio" name="searchType" value="class_room" > Class

    </div>
    <input type="submit" name="" value="Search" /> <button type="submit" name="submit" value="viewAll">View All</button>
</form>

    <p>-------------------------------------------------------------------------------------------</p>

    <table class="studentTable">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Middle Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Class room</th>
            <th>Grade</th>
            <th>Emergency Tel1</th>
            <th>Emergency Tel2</th>
            <th>Parent Status</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.first_name}</td>
                <td>${student.middle_name}</td>
                <td>${student.last_name}</td>
                <td>${student.address}</td>
                <td>${student.class_room}</td>
                <td>${student.grade}</td>
                <td>${student.emergency_phone1}</td>
                <td>${student.emergency_phone2}</td>
                <td>${student.parent_status}</td>
                <td><a  href="editStudentServlet?editID=${student.id}">edit</a></td>
                <td><a  href="deleteStudent?deleteID=${student.id}">delete</a></td>
            </tr>
        </c:forEach>
        <c:forEach var="foundList" items="${resultList}">
            <tr>
                <td>${foundList.id}</td>
                <td>${foundList.first_name}</td>
                <td>${foundList.middle_name}</td>
                <td>${foundList.last_name}</td>
                <td>${foundList.address}</td>
                <td>${foundList.class_room}</td>
                <td>${foundList.grade}</td>
                <td>${foundList.emergency_phone1}</td>
                <td>${foundList.emergency_phone2}</td>
                <td>${foundList.parent_status}</td>
                <td><a  href="editStudentServlet?editID=${student.id}">edit</a></td>
                <td><a  href="deleteStudent?deleteID=${student.id}">delete</a></td>
            </tr>
        </c:forEach>

    </table>

</body>
<%@include file="footer.jsp"%>
</html>
