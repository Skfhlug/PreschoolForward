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
<p>by ${user}</p>
<p>Total student : ${numberOfStudent}</p>
</body>

<p>-------------------------------------------------------------------------------------------</p>

<table class="studentTableForm">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Emotion Rate</th>
        <th>Eating Rate</th>
        <th>Sleeping Rate</th>
        <th>Save</th>
    </tr>

    <c:forEach var="student" items="${students}">

        <tr>
            <td>${student.id}</td>
            <td>${student.first_name} ${student.last_name}</td>
            <form  action="addStudentDailyReport?studentID=${student.id}" method="post">
            <td><div class="rating">
                <label>
                    <input type="radio" name="emotion-stars" value="1" />
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="emotion-stars" value="2" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="emotion-stars" value="3" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="emotion-stars" value="4" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="emotion-stars" value="5" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
            </div></td>

            <!------------------------------------------ Eating rate display---------------------------------------->
            <td><div class="rating">
                <label>
                    <input type="radio" name="eating-stars" value="1" />
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="eating-stars" value="2" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="eating-stars" value="3" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="eating-stars" value="4" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="eating-stars" value="5" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
            </div></td>
            <!---------------------------------------- Sleeping rate display------------------------------->
            <td><div class="rating">
                <label>
                    <input type="radio" name="sleeping-stars" value="1" />
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="sleeping-stars" value="2" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="sleeping-stars" value="3" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="sleeping-stars" value="4" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
                <label>
                    <input type="radio" name="sleeping-stars" value="5" />
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                    <span class="icon">★</span>
                </label>
            </div></td>
                <td><input type="submit" name="" value="Save" /><input type="button" name="absent" value="Absent" />
            </form></td>
        </tr>

    </c:forEach>
    <c:forEach var="foundList" items="${resultList}">
        <p>There are no student in database</p>
    </c:forEach>

</table>

<%@include file="footer.jsp"%>
</html>
