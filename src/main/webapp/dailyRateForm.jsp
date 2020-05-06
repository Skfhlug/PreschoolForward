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
<p>Total student : ${numberOfStudent}</p>
</body>

<p>-------------------------------------------------------------------------------------------</p>
<form  action="dailyRateForm" method="GET">
<table class="studentTableForm">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Emotion Rate</th>
        <th>Eating Rate</th>
        <th>Sleeping Rate</th>
    </tr>
    <!--<label>Total student:</label>-->
    <input type="hidden" name="totalStudent" class="form-control" value="${numberOfStudent}" />
    <!--<label>Total student:</label>-->
    <input type="hidden" name="user_id" class="form-control" value="<%= request.getRemoteUser()%>" />
    <!--<label>date:</label>-->
    <input type="hidden" name="todayDate" class="form-control" value="${date}" />
    <c:forEach var="student" items="${students}" varStatus="loop">
        <!--<label>ID:</label>-->
        <input type="hidden" name="studentID${loop.index}" class="form-control" value="${student.id}" />
        <tr>
            <td>${student.id}</td>
            <td>${student.first_name} ${student.last_name}</td>

                <td><div class="rating">
                    <label>
                        <input type="radio" name="emotion${loop.index}" value="1" />
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="emotion${loop.index}" value="2" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="emotion${loop.index}" value="3" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="emotion${loop.index}" value="4" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="emotion${loop.index}" value="5" />
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
                        <input type="radio" name="eating${loop.index}" value="1" />
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="eating${loop.index}" value="2" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="eating${loop.index}" value="3" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="eating${loop.index}" value="4" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="eating${loop.index}" value="5" />
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
                        <input type="radio" name="sleeping${loop.index}" value="1" />
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="sleeping${loop.index}" value="2" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="sleeping${loop.index}" value="3" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="sleeping${loop.index}" value="4" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                    <label>
                        <input type="radio" name="sleeping${loop.index}" value="5" />
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                        <span class="icon">★</span>
                    </label>
                </div></td>

        </tr>

    </c:forEach>
    <c:forEach var="foundList" items="${resultList}">
        <p>There are no student in database</p>
    </c:forEach>

</table>
    <input type="submit" name="" value="Save" />
</form>

<%@include file="footer.jsp"%>
</html>
