<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>


<div class="background1">
    <div class = "backgroundInfo">

        <h1>New User was added.</h1>
        <c:forEach var="list" items="${resultList}">

                <p>${list.id}</p>
                <p>${list.first_name}</p>
                <td>${list.last_name}</td>
                <td>${list.username}</td>
                <td>${list.email}</td>

        </c:forEach>
    </div>

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
