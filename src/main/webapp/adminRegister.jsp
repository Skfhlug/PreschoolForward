<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="White Steeple Preschool">
    <title>White Steeple Preschool</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Gothic+A1" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Cookie" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css"/>
</head>

<body>
<a class="skipLink" href="#mainContent">Skip to Main Content</a>
<a class="skipLink" href="#footer">Skip to Footer</a>

<header>
    <nav aria-label="main menu">
        <ul role="menubar">
            <li role="menuitem"><a href=index.jsp>Home</a></li>
            <li role="menuitem"><a href=gallery.html>Event Gallery</a></li>
            <li role="menuitem"><a href="resources.html">Resource</a></li>
            <li role="menuitem"><a href="studentRegister.jsp">Student Register</a></li>
            <!--<li role="menuitem"><a href="#">Activity <i class="fas fa-chevron-circle-down"></i>&nbsp;&nbsp;</a>
                <ul>
                    <li role="menuitem"><a href="#">Volunteer</a></li>
                    <li role="menuitem"><a href="#">Workshops and Courses</a></li>
                    <li role="menuitem"><a href="#">For the kids</a></li>
                </ul>
            </li>-->
        </ul>
    </nav>
</header>


<div id="background1">
    <div class = "backgroundInfo">
        <img id="logo" alt="School logo" src="img/schoolLogo.png" />
        <h1 class="nameFont1">Admin Register</h1>


        <form action="#" method="post">
            <div>

                <label>First Name:</label>
                <input type="text" name="first_name" class="form-control" placeholder="First Name"/><br />

                <label>Last Name:</label>
                <input type="text" name="last_name" class="form-control" placeholder="Last Name"/><br />

                <label>Username:</label>
                <input type="text" name="username" class="form-control" /><br />

                <label>Password:</label>
                <input type="text" name="password" class="form-control" /><br />

                <label>Email:</label>
                <input type="text" name="email" class="form-control" /><br />

                <label>Phone:</label>
                <input type="text" name="phone" class="form-control" placeholder="000-000-0000"/><br />
            </div>

            <input type="submit" name="" value="Add New Admin" />
        </form>

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
