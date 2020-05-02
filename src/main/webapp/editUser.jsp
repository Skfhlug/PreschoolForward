<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/20
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<body>

<h1 class="nameFont1">User Register</h1>


        <div class="formDesign">
            <form action="editUserServlet" method="post">
                <div class="form-group col-md-6">
                    <!--<label>ID:</label>-->
                    <input type="hidden" name="id" class="form-control" value="${user.id}" />
                </div>

                <div class="form-group col-md-6">
                    <label>Username: ${user.username}</label>
                    <input type="hidden" name="username" class="form-control" value="${user.username}" />
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Password:</label>
                        <input type="password" name="password" class="form-control" value="${user.password}"/>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>First Name:</label>
                        <input type="text" name="first_name" class="form-control" value="${user.first_name}"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Last Name:</label>
                        <input type="text" name="last_name" class="form-control" value="${user.last_name}"/>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Email:</label>
                        <input type="email" name="email" class="form-control" value="${user.email}"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label>Phone :</label>
                        <input type="text" name="phone" class="form-control" value="${user.phone}"/>
                    </div>
                </div>

                <input type="submit" name="" value="Edit User" />
            </form>

        </div>

</body>
<%@include file="footer.jsp"%>
</html>