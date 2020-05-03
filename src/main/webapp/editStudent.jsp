<%--
  Created by IntelliJ IDEA.
  student: suparin
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
                <input type="text" name="first_name" class="form-control" value="${student.first_name}" required/>
            </div>
            <div class="form-group col-md-4">
                <label>Middle Name:</label>
                <input type="text" name="middle_name" class="form-control" value="${student.middle_name}" required/>
            </div>
            <div class="form-group col-md-4">
                <label>Last Name:</label>
                <input type="text" name="last_name" class="form-control" value="${student.last_name}" required/>
            </div>
        </div>

        <div class="form-group">
            <label>Gender</label><br>
            <label><input type="radio" class="radio" name="gender" value="male"
            <c:if test = "${student.gender == 'male'}">
                          checked
            </c:if>>Male  </label>
            <label><input type="radio" class="radio" name="gender" value="female"
            <c:if test = "${student.gender == 'female'}">
                          checked
            </c:if>>Female </label>
        </div>
        <div class="form-group">
            <label>Address:</label>
            <input type="text" name="address" class="form-control" value="${student.address}" required/>
        </div>
        <div class="form-group">
            <label>Date of birth:</label>
            <input type="date" name="date_of_birth" class="form-control" value="${student.date_of_birth}" required/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Class:</label>
                <input type="text" name="class_room" class="form-control" value="${student.class_room}" required/>
            </div>
            <div class="form-group col-md-6">
                <label>Grade  </label><br>
                <label><input type="radio" class="radio" name="grade" value="Junior"
                <c:if test = "${student.grade == 'Junior'}">
                              checked
                </c:if>>Junior  </label>
                <label><input type="radio" class="radio" name="grade" value="Senior"
                <c:if test = "${student.grade == 'Senior'}">
                              checked
                </c:if> >Senior  </label>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Emergency Phone Number1 :</label>
                <input type="text" name="emergency_phone1" class="form-control" value="${student.emergency_phone1}" required/>
            </div>
            <div class="form-group col-md-6">
                <label>Emergency Phone Number2:</label>
                <input type="text" name="emergency_phone2" class="form-control" value="${student.emergency_phone2}" required/>
            </div>
        </div>
        <div class="form-group">
            <label>Picture Address:</label>
            <input type="text" name="picture_address" class="form-control" value="${student.picture_address}"/>
        </div>
        <div class="form-group">
            <label>Marital Status </label><br>
            <label><input type="radio" class="radio" name="parent_status" value="Married"
            <c:if test = "${student.parent_status == 'Married'}">
                checked
            </c:if> >Married  </label>
            <label><input type="radio" class="radio" name="parent_status" value="Separated"
            <c:if test = "${student.parent_status == 'Separated'}">
                   checked
            </c:if> >Separated  </label>
        </div>

        <input type="submit" name="" value="Edit Student" />    </form>

</div>

</body>
<%@include file="footer.jsp"%>
</html>
