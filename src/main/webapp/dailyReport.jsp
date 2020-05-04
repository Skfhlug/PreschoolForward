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

<div class="dailyReport">


    <!--/*
        <h1>${info}</h1>
        <p>Parent Id: ${parent_id}</p>
        <p>Student ID : ${student.id}</p>
        <h2>${student.first_name} ${student.last_name}</h2> <p class="dateRight">${date}</p>

    */-->
    <h1>Daily Report</h1>
    <h2>${student.first_name} ${student.last_name}</h2>
    <p class="dateRight">${date}</p>
    <p class="titleRate">Emotion rate:
        <div class="emotion rating">
            <c:choose>
                <c:when test="${report.emotion == 1}">
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                </c:when>
                <c:when test="${report.emotion == 2}">
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                </c:when>
                <c:when test="${report.emotion == 3}">
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                </c:when>
                <c:when test="${report.emotion == 4}">
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#ADADC9;">&starf;</span>
                </c:when>
                <c:when test="${report.emotion == 5}">
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                    <span class="emotion" style="font-size:100%;color:#FF7417;">&starf;</span>
                </c:when>
            </c:choose>
        </div></p>
    <p class="titleRate">Eating rate:  <div class="eating rating">
        <c:choose>
            <c:when test="${report.emotion == 1}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 2}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 3}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 4}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 5}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
            </c:when>
        </c:choose>
    </div>
    </p>
    <p class="titleRate">Sleeping rate:
        <div class="sleeping rating">
        <c:choose>
            <c:when test="${report.emotion == 1}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 2}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 3}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 4}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.emotion == 5}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
            </c:when>
        </c:choose>
    </div></p>

</div>
</body>
</html>
