<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 5/1/2020
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<title>Add Student Success</title>

<div class="background1">
    <div class = "backgroundInfo">

        <c:if test="${studentAdded != null}" >
            <p class="addStatus">${studentAdded}</p>
            <c:set var="studentAdded"  scope="session" />
            <c:remove var="studentAdded"/>
        </c:if>
        <a href = "searchParent?searchTerm=&searchType=id&submit=viewAll"><button>Go to Parent Page</button></a>
    <table class="studentTable">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Middle Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Class room</th>
            <th>Grade</th>
            <th>Emergency Tel1</th>
            <th>Emergency Tel2</th>
            <th>Parent Status</th>

        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.first_name}</td>
                <td>${student.middle_name}</td>
                <td>${student.last_name}</td>
                <td>${student.address}</td>
                <td>${student.class_room}</td>
                <td>${student.grade}</td>
                <td><a href="tel:${student.emergency_phone1}">${student.emergency_phone1}</a></td>
                <td><a href="tel:${student.emergency_phone1}">${student.emergency_phone2}</a></td>
                <td>${student.parent_status}</td>
            </tr>
        </c:forEach>
    </table>
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
