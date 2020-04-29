<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/28/2020
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="head.jsp"%>
<%@include file="header.jsp"%>


<head>
    <title>Add Parent Successful</title>
</head>
<body>

<table class="userTable">
    <tr>
        <th>ID</th>
        <th>Parent Name</th>
        <th>Student Name</th>
        <th>grade</th>
        <th>class</th>


    </tr>
    <c:forEach var="parent" items="${parents}">
        <tr>
            <td>${parent.id}</td>
            <td>${parent.user.first_name} ${parent.user.last_name}</td>
            <td>${parent.student.first_name} ${parent.student.last_name}</td>
            <td>${parent.student.grade}</td>
            <td>${parent.student.class_room}</td>

        </tr>
    </c:forEach>
    <c:forEach var="foundList" items="${resultList}">
        <tr>
            <td>${foundList.id}</td>
            <td>${foundList.user.first_name} ${parent.user.last_name}</td>
            <td>${foundList.student.first_name} ${parent.student.last_name}</td>
            <td>${foundList.student.grade}</td>
            <td>${foundList.student.class_room}</td>

        </tr>
    </c:forEach>

</table>

</body>
</html>
