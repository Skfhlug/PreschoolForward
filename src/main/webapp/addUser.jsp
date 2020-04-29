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
        <form action="addUserServlet" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>First Name:</label>
                    <input type="text" name="first_name" class="form-control" placeholder="First Name" required/>
                </div>
                <div class="form-group col-md-6">
                    <label>Last Name:</label>
                    <input type="text" name="last_name" class="form-control" placeholder="Last Name" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Username:</label>
                    <input type="text" name="username" class="form-control" placeholder="username" required/>
                </div>
                <div class="form-group col-md-6">
                    <label>Password:</label>
                    <input type="password" name="password" class="form-control" placeholder="" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group form-group col-md-6">
                    <label>Email:</label>
                    <input type="email" name="email" class="form-control" placeholder="youremail@somemail.com" required/>
                </div>

                <div class="form-group form-group col-md-6">
                    <label>Phone :</label>
                    <input type="text" name="phone" class="form-control" placeholder="0000000000" required/>
                </div>
            </div>

            <input type="submit" name="" value="Add New User" />
        </form>
    </div>

</body>
<%@include file="footer.jsp"%>
</html>
