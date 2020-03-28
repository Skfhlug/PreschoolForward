<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>


<c:if test="${pageContext.request.isUserInRole('admin')}">
    <a href="adminRegister.jsp">Add Admin (this link will display when admin logged in)</a>
</c:if>

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
<!--
    <div id="picAndClick">
        <img id="smallTree" alt="Small tree in human hands" src="images/smallTree.jpeg" />
    </div>

    <div class = "backgroundInfo">

        <p>What do you receive if you buy a plot?</p>

        <ul>
            <li>The county provides the land to rent, liability insurance, and water, which is made available throughout the summer.</li>
            <li>Upgraded water lines are maintained.</li>
            <li>Grass borders are mowed to prevent rodent habitat.</li>
            <li>A Port-a-Potty is provided for your convenience.</li>
            <li>Free garden seeds, teaching materials, and advice is provided from mentors in our newsletters.</li>
            <li>The garden is tilled in the fall and early spring as soil conditions allow.</li>
            <li>The plots get measured, marked, and monitored.</li>
        </ul>

    </div>-->


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
