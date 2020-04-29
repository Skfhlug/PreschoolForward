<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/21/2020
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parent</title>
</head>
<body>

<h2>Parents Information: </h2>
<p>Admin: ${user}</p>
<form action="searchParent" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="Enter Searching key here" />
    </div>
    <div class="form-group">
        <label>Type:</label>
        <input type="radio" name="searchType" value="id" checked> ID &nbsp;
        <input type="radio" name="searchType" value="student_id"> Student ID
        <input type="radio" name="searchType" value="user_id" > User ID &nbsp;

    </div>
    <input type="submit" name="" value="Search" /><button type="submit" name="submit" value="viewAll">View All</button>
</form>

<p>-------------------------------------------------------------------------------------------</p>

<table class="userTable">
    <tr>
        <th>ID</th>
        <th>Parent Name</th>
        <th>Student Name</th>
        <th>grade</th>
        <th>class</th>
        <th>Edit</th>

    </tr>
    <c:forEach var="parent" items="${parents}">
        <tr>
            <td>${parent.id}</td>
            <td>${parent.user.first_name} ${parent.user.last_name}</td>
            <td>${parent.student.first_name} ${parent.student.last_name}</td>
            <td>${parent.student.grade}</td>
            <td>${parent.student.class_room}</td>
            <td><a  href="editParentServlet?editID=${parent.id}">edit</a></td>
        </tr>
    </c:forEach>
    <c:forEach var="foundList" items="${resultList}">
        <tr>
            <td>${foundList.id}</td>
            <td>${foundList.user.first_name} ${parent.user.last_name}</td>
            <td>${foundList.student.first_name} ${parent.student.last_name}</td>
            <td>${foundList.student.grade}</td>
            <td>${foundList.student.class_room}</td>
            <td><a  href="editParentServlet?editID=${parent.id}">edit</a></td>
        </tr>
    </c:forEach>

</table>

</body>
<%@include file="footer.jsp"%>
</html>
