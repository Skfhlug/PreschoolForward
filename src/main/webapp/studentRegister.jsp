<%--
  Created by IntelliJ IDEA.
  student: suparin
  Date: 5/2/2020
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<!doctype>
<html lang="en">
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<div id="background1">
    <div class = "backgroundInfo">

        <h1 class="nameFont1">Student Register</h1>
        <div class="formDesign">
        <form action="addStudentServlet" method="post">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>First Name:</label>
                    <input type="text" name="first_name" class="form-control form-control" placeholder="First Name"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Middle Name:</label>
                    <input type="text" name="middle_name" class="form-control form-control" placeholder="Middle Name"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Last Name:</label>
                    <input type="text" name="last_name" class="form-control" placeholder="Last Name"/>
                </div>
            </div>
            <div class="form-group">
                <label>Gender</label><br>
                <label><input type="radio" class="radio" name="gender" value="male">Male  </label>
                <label><input type="radio" class="radio" name="gender" value="female" checked>Female </label>
            </div>
            <div class="form-group">
                <label>Address:</label>
                <input type="text" name="address" class="form-control" placeholder="address"/>
            </div>
            <div class="form-group">
                <label>Date of birth:</label>
                <input type="date" name="date_of_birth" class="form-control" placeholder="YYYY-MM-DD"/>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Class:</label>
                    <input type="text" name="class_room" class="form-control" placeholder="class room"/>
                </div>
                <div class="form-group col-md-6">
                    <label>Grade  </label><br>
                    <label><input type="radio" class="radio" name="grade" value="junior" checked>Junior  </label>
                    <label><input type="radio" class="radio" name="grade" value="senior" >Senior  </label>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Emergency Phone Number1 :</label>
                    <input type="text" name="emergency_phone1" class="form-control" placeholder="0000000000"/>
                </div>
                <div class="form-group col-md-6">
                    <label>Emergency Phone Number2:</label>
                    <input type="text" name="emergency_phone2" class="form-control" placeholder="0000000000"/>
                </div>
            </div>
            <div class="form-group">
                <label>Picture Address:</label>
                <input type="file" name="picture_address" class="form-control" placeholder="xxxx.png"/>
            </div>
            <div class="form-group">
                    <label>marital Status </label><br>
                    <label><input type="radio" class="radio" name="parent_status" value="Married" checked>Married  </label>
                    <label><input type="radio" class="radio" name="parent_status" value="Separated" >Separated  </label>
            </div>

            <input type="submit" name="" value="Add New Student" />
        </form>
        </div>
    </div>
</div>


</body>
<%@include file="footer.jsp"%>
</html>
