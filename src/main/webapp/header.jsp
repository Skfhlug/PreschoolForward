<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/9/2020
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<body>
<header>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav aria-label="main menu">
        <a href="logout.jsp" class="loginLink">  |  Logout</a>
        <a href="welcomeAdmin.jsp" class="loginLink">Log in</a>
        <p>${active_username}</p>

        <a href=index.jsp><img id="logo" alt="School logo" src="img/schoolLogo.png" /></a>
        <ul role="menubar">
            <li role="menuitem"><a href=index.jsp>Home</a></li>
            <li role="menuitem"><a href=gallery.html>Event Gallery</a></li>
            <li role="menuitem"><a href="resources.html">Resource</a></li>
            <li role="menuitem"><a href="#">Register <i class="fas fa-chevron-circle-down"></i>&nbsp;&nbsp;</a>
                <ul>
                    <li role="menuitem"><a href="studentRegister.jsp">Student Register</a></li>
                    <li role="menuitem"><a href="reminder.jsp">Reminder</a></li>
                    <li role="menuitem"><a href="user.jsp">Users</a></li>
                    <li role="menuitem"><a href="student.jsp">Student</a></li>
                </ul>
            </li>
        </ul>
    </nav>

</header>
