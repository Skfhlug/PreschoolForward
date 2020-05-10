<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/28/2020
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<title>Add Parent Success</title>


<body>

<c:forEach var="student" items="${users}">
        <p>${user.first_name} ${user.last_name} is a parent of ${student.first_name} ${student.last_name} </p>
</c:forEach>
</body>
<%@include file="footer.jsp"%>

</html>