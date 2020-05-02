<%--
  Created by IntelliJ IDEA.
  student: supar
  Date: 5/1/2020
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<body>

<h1 class="nameFont1">Edit Student Information</h1>


<div class="formDesign">
    <form action="editStudentServlet" method="post">
        <div class="form-group col-md-6">
            <!--<label>ID:</label>-->
            <input type="hidden" name="id" class="form-control" value="${student.id}" />
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label>First Name:</label>
                <input type="text" name="first_name" class="form-control" value="${student.first_name}"/>
            </div>
            <div class="form-group col-md-4">
                <label>Last Name:</label>
                <input type="text" name="last_name" class="form-control" value="${student.last_name}"/>
            </div>
        </div>

        <input type="submit" name="" value="Edit Student" />
    </form>

</div>

</body>
<%@include file="footer.jsp"%>
</html>
