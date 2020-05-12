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
<c:if test="${addedParent != null}" >
    <p class="addStatus">${addedParent}</p>
    <c:set var="addedParent"  scope="session" />
    <c:remove var="addedParent"/>
</c:if>


<p>Parent was added</p>
</body>
<%@include file="footer.jsp"%>

</html>