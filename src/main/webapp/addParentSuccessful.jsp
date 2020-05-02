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

<c:forEach var="student" items="${users}">
        <p>${user.first_name} ${user.last_name} is a parent of ${student.first_name} ${student.last_name} </p>

</body>
<%@include file="footer.jsp"%>
</html>
