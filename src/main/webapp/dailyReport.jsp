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


    <h1 class="dateReport">Daily Report date: ${date}</h1>
    <h2 class="studentNameInReport">${student.first_name} ${student.last_name}</h2>
    <br>
    <c:if test = "${reminders.status == 'display'}">
        <br><br>
        <p style="font-weight: bold;">${reminders.reminder_title}</p>
        <p>${reminders.description}</p>
    </c:if>

    <div class="studentPic"><img src="img/${student.picture_address}"/></div>

<br><br>


    <h3 class="d">Emotion rate: </h3>
        <div class="emotion-block rating a">
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
        </div>
    <h3 class="b">Eating rate:  </h3>
        <div class="eating-block rating b">
        <c:choose>
            <c:when test="${report.eating == 1}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.eating == 2}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.eating == 3}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.eating == 4}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.eating == 5}">
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="eating" style="font-size:100%;color:#FF7417;">&starf;</span>
            </c:when>
        </c:choose>
    </div>

    <h3 class="c">Sleeping rate: </h3>
        <div class="sleeping-block rating c">
        <c:choose>
            <c:when test="${report.sleeping == 1}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.sleeping == 2}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.sleeping == 3}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.sleeping == 4}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#ADADC9;">&starf;</span>
            </c:when>
            <c:when test="${report.sleeping == 5}">
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
                <span class="sleeping" style="font-size:100%;color:#FF7417;">&starf;</span>
            </c:when>
        </c:choose>
    </div>

</div>
</body>
<%@include file="footer.jsp"%>
</html>
