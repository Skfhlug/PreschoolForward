<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>


<div class="background1">
    <div class = "backgroundInfo">

        <h1>New User was added.</h1>
        <c:forEach var="list" items="${resultList}">

            <p>User ID:  ${list.id}</p>
            <p>Name:     ${list.first_name} ${list.last_name}</p>
            <p>Username: ${list.username}</p>
            <p>Email:    ${list.email}</p>
            <p>Role:     ${role}</p>

        </c:forEach>
    </div>
<table class="userTable">
<tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Username</th>
    <th>Email</th>
    <th>Phone</th>
</tr>
<c:forEach var="user" items="${users}">
    <tr>
        <td>${user.id}</td>
        <td>${user.first_name}</td>
        <td>${user.last_name}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.phone}</td>
    </tr>
</c:forEach>
</table>

</div>

<footer>
    <div class="ftCopyLeft">
        <p><i class="fas fa-phone"></i> CONTACT US :<a href="tel:+01-773-631-3129"> (773) 631-3129</a></p>
        <p><i class="fas fa-envelope"></i> Email :<a href="mailto:whitesteeple@somemail.com"> whitesteeple@somemail.com</a></p>
        <p><i class="fas fa-clock"></i> Office Hours: Mon-Fri 8:00 - 22:00</p>
    </div>
    <div class="ftCopyRight">
        <p> White Steeple Schoool|  <a href="#">Privacy Policy</a></p>
        <p>Design by Suparin Fhlug</p>
        <p>&copy; White Steeple School, 5849 N Nina Ave, Chicago, IL 60631</p>
    </div>
</footer>


</body>
</html>
