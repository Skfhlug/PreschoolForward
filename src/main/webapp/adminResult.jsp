<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>

<html><body>


<div class="container-fluid">
    <h2>Search Admin Results: </h2>

</div>

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
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>

</table>
<form action="searchAdmin" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="last name"/><br />
    </div>
    <div class="form-group">
        <label>Type:</label><br />
        <input type="radio" name="searchType" value="id" checked> ID <br>
        <input type="radio" name="searchType" value="firstName" > First Name<br>
        <input type="radio" name="searchType" value="lastName"> Last Name<br>
        <input type="radio" name="searchType" value="usetname" > First Name<br>


    </div>
    <input type="submit" name="" value="Search" />
</form>

<table class="adminTable">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
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