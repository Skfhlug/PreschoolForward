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

        <c:choose>
            <c:when test="${(pageContext.request.isUserInRole('admin')) ||
                                    (pageContext.request.isUserInRole('teacher')) ||
                                    (pageContext.request.isUserInRole('parent')) }">
                <a href="logout.jsp" class="loginLink">  |  Logout</a>
                <p class="usernameHeader">Welcome : <%= request.getRemoteUser()%></p>
            </c:when>
            <c:otherwise>
                <a href="welcomeAdmin.jsp" class="loginLink">Log in</a>
            </c:otherwise>
        </c:choose>

        <a href=index.jsp><img id="logo" alt="School logo" src="img/schoolLogo.png" /></a>
        <ul role="menubar">
            <li role="menuitem"><a href=index.jsp>Home</a></li>
            <li role="menuitem"><a href=gallery.jsp>Event Gallery</a></li>
            <li role="menuitem"><a href="resources.html">Resource</a></li>
            <li role="menuitem"><a href="#">More(admin only) <i class="fas fa-chevron-circle-down"></i>&nbsp;&nbsp;</a>
                <ul>
                    <li role="menuitem"><a href="studentRegister.jsp">Student Register</a></li>
                    <li role="menuitem"><a href="reminder?searchTerm=&searchType=id&submit=viewAll">Reminder</a></li>
                    <li role="menuitem"><a href="searchUser?searchTerm=&searchType=id&submit=viewAll">Users</a></li>
                    <li role="menuitem"><a href="searchParent?searchTerm=&searchType=id&submit=viewAll">Parent</a></li>
                    <li role="menuitem"><a href="searchStudent?searchTerm=&searchType=id&submit=viewAll">Student</a></li>
                    <li role="menuitem"><a href="selectRoom.jsp">Daily form </a></li>

                </ul>
            </li>
        </ul>
    </nav>

</header>
