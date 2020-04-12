<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/8/2020
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="header.jsp"%>
<%@include file="header.jsp"%>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.invalidate();
    response.sendRedirect("/index.jsp");
%>
<%@include file="footer.jsp"%>
</body>
</html>
