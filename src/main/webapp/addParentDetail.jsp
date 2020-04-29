<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/28/2020
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<head>
    <title>Added Student In Control </title>
</head>
<body>
    <h1>Add parent information</h1>
    <c:if test="${sessionRole != null}" >
        <p class="addStatus">Username:    ${sessionUsername}</p>
        <p class="addStatus">User Status: ${sessionRole}</p>
        <form action="addParent" method="post">
            <div class="form-group col-cm-3">
                <label>Username:</label>
                <input type="text" name="username" class="form-control"  value="${sessionUsername}" disabled/>

                <label>Student Id Control:</label>
                <input type="text" name="studentID" class="form-control" placeholder="" required/>
                <br/>
                <input type="submit" name="" value="Add Student In control" />
            </div>
        </form>
        <c:set var="sessionRole"  scope="session" />
    </c:if>
    <h2>Student Information</h2>
    <hr>
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
        </tr>
        </c:forEach>


</body>
</html>
