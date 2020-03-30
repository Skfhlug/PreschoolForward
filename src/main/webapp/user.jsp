<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="head.jsp"%>

<html><body>

<h2>Search User Results: </h2>

<a href="addUser.jsp"><button>Add User</button></a>
<form action="searchUser" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="last name"/>
    </div>
    <div class="form-group">
        <label>Type:</label>
        <input type="radio" name="searchType" value="id" checked> ID &nbsp;
        <input type="radio" name="searchType" value="first_name" > First Name &nbsp;
        <input type="radio" name="searchType" value="last_name"> Last Name &nbsp;
        <input type="radio" name="searchType" value="username" > Username &nbsp;


    </div>
    <input type="submit" name="" value="Search" />
</form>

<p>-------------------------------------------------------------------------------------------</p>

    <table class="userTable">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.username}</td>

            </tr>
        </c:forEach>
        <c:forEach var="foundList" items="${resultList}">
            <tr>
                <td>${foundList.id}</td>
                <td>${foundList.first_name}</td>
                <td>${foundList.last_name}</td>
                <td>${foundList.username}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>