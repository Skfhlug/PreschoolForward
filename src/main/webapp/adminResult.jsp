<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>

<html><body>


<div class="container-fluid">
    <h2>Search Admin Results: </h2>
</div>
<form action="searchAdmin" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="last name"/>
    </div>
    <div class="form-group">
        <label>Type:</label>
        <input type="radio" name="searchType" value="id" checked> ID &nbsp;
        <input type="radio" name="searchType" value="firstName" > First Name &nbsp;
        <input type="radio" name="searchType" value="lastName"> Last Name &nbsp;
        <input type="radio" name="searchType" value="username" > Username &nbsp;


    </div>
    <input type="submit" name="" value="Search" />
</form>
<a class="add" href="adminRegister.jsp">+</a>
<p>-------------------------------------------------------------------------------------------</p>

<table class="adminTable">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    <c:forEach var="admin" items="${admins}">
        <tr>
            <td>${admin.id}</td>
            <td>${admin.firstName}</td>
            <td>${admin.lastName}</td>
            <td>${admin.username}</td>
            <td>${admin.email}</td>
            <td>${admin.phone}</td>
        </tr>
    </c:forEach>
    <c:forEach var="foundList" items="${resultList}">
        <tr>
            <td>${foundList.id}</td>
            <td>${foundList.firstName}</td>
            <td>${foundList.lastName}</td>
            <td>${foundList.username}</td>
            <td>${foundList.email}</td>
            <td>${foundList.phone}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>