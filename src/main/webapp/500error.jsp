<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 5/5/2020
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:set var="title" value="500 Error" />
<%@include file="head.jsp"%>
</head>
<body>

<main class="container wrapper" >

    <h1 class="alert alert-warning">Something is not right! Your data wasn't added. Please contact admin or check again after 6PM</h1>
    <h2 class="alert alert-info"><a class="btn btn-link" href="/PreschoolForward">Back </a></h2>
</main>
<%@include file="footer.jsp"%>

