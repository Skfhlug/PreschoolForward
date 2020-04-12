<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/9/20
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<body>

    Welcome Admin
    <a href = "addReminder.jsp"><button>Add Reminder</button></a>
    <a href = "reminder.jsp"><button>Reminder</button></a>
    <a href = "user.jsp"><button>User</button></a>

    <div class="background1">
        <div class = "backgroundInfo">

            <br>
            <img id="kid5" alt="picture of kids" src="img/kid5.jpg" />
            <h1 class="nameFont1">Welcome to White Steeple Preschool</h1>


            <p class="schoolInfo">White Steeple Preschool has served our community for more than 50 years.  With a long-term dedicated teacher team,
                perfect class size, affordable tuition fees and an academically-enriched curriculum, White Steeple Preschool is highly recommended and
                recognized from parents in Norwood Park District and neighboring communities.</p>
            <br/>
            <p>At White Steeple, we provide the first positive learning experiences in each child’s life.  Children will learn with creativity and support
                from our caring and fostering teachers to nurture their curiosity.  Along with building self-discipline, self-esteem, respect and social manners,
                they will make friends in a safe and cooperative environment that allows children to have fun and gain confidence in preparing for the next
                milestones in their lifetime of learning.</p>
            <br/>
            <p>We understand that families may have different schedules and budgets,  therefore you may choose from our morning and afternoon programs to best fit your needs.
                Registration for each new school year begins in the first week of February.  To save a place for your child, make sure to register as soon as possible!
                For more information please contact Mrs. Kathy Choporis at 773-631-3129
            </p>
            <br/>
            <h2>Why White Steeple?</h2>
            <p>Fostering, caring and experienced teachers
                Enriched structured curriculum
                Adequate class size, with great teacher-to-student ratio
                Creative and positive atmosphere
                Respectful for each child’s individual development
                Building readiness through learning oriented activities that provide a fun learning environment
                Building self-discipline, self-esteem and social manners
                A well-rounded program with an affordable tuition fee</p>
        </div>
    <%@include file="footer.jsp"%></body>
</html>
