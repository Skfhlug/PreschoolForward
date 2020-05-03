<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/2/20
  Time: 3:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Daily Report</title>
</head>
<body>
    <h1>${info}</h1>
    <h2>Student Name: ${student.first_name} ${student.last_name}</h2>
    <p>${date}</p>

    <p>Emotion rate: ${report.emotion}</p>
    <p>Eating rate:  ${report.eating}</p>
    <p>Sleeping rate: ${report.sleeping}</p>

    <p>Updated by: ${report.user_id}</p>
</body>
</html>
