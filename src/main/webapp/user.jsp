<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html><body>

<h2>Search User Results: </h2>

<a href="addUser.jsp"><button>Add User</button></a>
<form action="searchUser" method="GET">
    <div class="form-group">
        <label>What are you looking for:</label>
        <input type="text" name="searchTerm" class="form-control" placeholder="Enter Searching key here" />
    </div>
    <div class="form-group">
        <label>Type:</label>

        <input type="radio" name="searchType" value="first_name"  checked> First Name &nbsp;
        <input type="radio" name="searchType" value="last_name"> Last Name &nbsp;
        <input type="radio" name="searchType" value="username" > Username &nbsp;
        <input type="radio" name="searchType" value="email"> Email &nbsp;
        <input type="radio" name="searchType" value="phone" > Phone &nbsp;


    </div>
    <input type="submit" name="submit" value="Search" /><button type="submit" name="submit" value="viewAll">View All</button>
</form>

<p>-------------------------------------------------------------------------------------------</p>

    <table class="userTable">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td><a  href="editUserServlet?editID=${user.id}">edit</a></td>
                <td><a  href="deleteUser?deleteID=${user.id}">delete</a></td>
            </tr>
        </c:forEach>
        <c:forEach var="foundList" items="${resultList}">
            <tr>
                <td>${foundList.id}</td>
                <td>${foundList.first_name}</td>
                <td>${foundList.last_name}</td>
                <td>${foundList.username}</td>
                <td>${foundList.email}</td>
                <td>${foundList.phone}</td>
                <td><a href="editUserServlet?editID=${user.id}">edit</a></td>
                <td><a  href="deleteUser?deleteID=${user.id}">delete</a></td>
            </tr>
        </c:forEach>

    </table>

</body>
<%@include file="footer.jsp"%>
</html>