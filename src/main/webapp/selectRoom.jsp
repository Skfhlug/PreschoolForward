<%--
  Created by IntelliJ IDEA.
  User: supar
  Date: 4/27/2020
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html><body>
<h1>Daily Form for ${date}</h1>
<p>by <%= request.getRemoteUser()%></p>

</body>

<p>-------------------------------------------------------------------------------------------</p>
<form action="dailyAction" method="GET">

    <div class="form-group">
        <label>Class:</label>

        <input type="radio" name="student_class" value="A"  checked> A &nbsp;
        <input type="radio" name="student_class" value="B"> B
        <input type="radio" name="student_class" value="C" > C

    </div>
    <div class="form-group">
        <label>Grade:</label>

        <input type="radio" name="student_grade" value="Junior"  checked> Junior&nbsp;
        <input type="radio" name="student_grade" value="Senior"> Senior &nbsp;

    </div>
    <input type="submit" name="submit" value="submit" /></button>
</form>

<%@include file="footer.jsp"%>
</html>
