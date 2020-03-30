<!doctype>
<html lang="en">
<%@include file="head.jsp"%>


<div id="background1">
    <div class = "backgroundInfo">

        <h1 class="nameFont1">Student Register</h1>
        <div class="formDesign">
        <form action="addStudentServlet" method="post">

            <div class="form-group">
                <label>First Name:</label>
                <input type="text" name="first_name" class="form-control displayHalfForm" placeholder="First Name"/>
            </div>
            <div class="form-group">
                <label>Middle Name:</label>
                <input type="text" name="middle_name" class="form-control displayHalfForm" placeholder="Middle Name"/>
            </div>
            <div class="form-group">
                <label>Last Name:</label>
                <input type="text" name="last_name" class="form-control" placeholder="Last Name"/>
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
                <input type="text" name="date_of_birth" class="form-control" placeholder="YYYY-MM-DD"/>
            </div>
            <div class="form-group">
                <label>Class:</label>
                <input type="text" name="class_room" class="form-control" placeholder="class room"/>
            </div>
            <div class="form-group">
                <label>Grade  </label><br>
                <label><input type="radio" class="radio" name="grade" value="junior" checked>Junior  </label>
                <label><input type="radio" class="radio" name="grade" value="senior" >Senior  </label>
            </div>
            <div class="form-group">
                <label>Emergency Phone Number1 :</label>
                <input type="text" name="emergency_phone1" class="form-control" placeholder="0000000000"/>
            </div>
            <div class="form-group">
                <label>Emergency Phone Number2:</label>
                <input type="text" name="emergency_phone2" class="form-control" placeholder="0000000000"/>
            </div>
            <div class="form-group">
                <label>Picture Address:</label>
                <input type="text" name="picture_address" class="form-control" placeholder="xxxx.png"/>
            </div>
            <div class="form-group">
                    <label>marital Status </label><br>
                    <label><input type="radio" class="radio" name="parent_status" value="Married" checked>Married  </label>
                    <label><input type="radio" class="radio" name="parent_status" value="Separated" >Separated  </label>
            </div>

            <input type="submit" name="" value="Add New Employee" />
        </form>
        </div>
    </div>
</div>

    <footer>
        <div class="ftCopyLeft">
            <p><i class="fas fa-phone"></i> CONTACT US :<a href="tel:+01-773-631-3129"> (773) 631-3129</a></p>
            <p><i class="fas fa-envelope"></i> Email :<a href="mailto:whitesteeple@somemail.com"> whitesteeple@somemail.com</a></p>
            <p><i class="fas fa-clock"></i> Office Hours: Mon-Fri 8:00 - 22:00</p>
        </div>
        <div class="ftCopyRight">
            <p> White Steeple Schoool|  <a href="#">Privacy Policy</a></p>
            <p>Design by Suparin Fhlug</p>
            <p>&copy; White Steeple School, 5849 N Nina Ave, Chicago, IL 60631</p>
        </div>
    </footer>
</body>
</html>
