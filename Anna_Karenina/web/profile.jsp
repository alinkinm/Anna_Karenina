<%@ page import="models.User" %>
<%@ page import="dao.PostDAO" %>
<%@ page contentType="text/html;charset=cp1251" language="java" %>



<html>

<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=cp1251">
    <title>   User Logged Successfully   </title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="jquery/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <title>Ролевая игра "Анна Каренина"</title>
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="jquery/docs.min.js"></script>
</head>

<body>

<div style="text-align: center;">

</div>
<script>
    /* When the user clicks on the button,
    toggle between hiding and showing the dropdown content */
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
</script>
<div class="header">
    <h1 align="right" class="header-text1">
        Ролевая игра
    </h1>
    <h1 align="right" class="header-text2">
        "Анна Каренина"
    </h1>
</div>

<div>
    <ul id="main-menu" class="nav nav-tabs" align="center">
        <li class="nav-item nav-fill">
            <a class="nav-link" href="${pageContext.request.contextPath}/profile">Мой профиль</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" onclick="myFunction(); return false" role="button">Игра</a>
            <div class="dropdown-menu" id="myDropdown">
                <a class="dropdown-item" href="#">Сюжет</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/locations">Локации</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/createLocation">Создать локацию</a>
                <a class="dropdown-item" href="#">Список персонажей</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/createhero">Создание персонажа</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Правила</a>
        </li>
        <li>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </li>
    </ul>
</div>

<div class="page-title" align="center">
    <h3>Мой профиль</h3>
</div>

<div class="profile" align="center">
    <div class="about-user" alin="center">
        <p><div class="author"><a href="#"><%= session.getAttribute("username") %></a></div></p>
        <!--<p><div class="status">я не хочу ничего решать я жду поезд</div></p>-->
        <p><img src="<%=session.getAttribute("photo")%>" width="180" height="180" class="avatar" align="center" alt="ыыы"></p>
    </div>
    <div class="posts-user">

        <p><a href="#">О себе: <%=session.getAttribute("about")%></a></p>
        <p><a href="#">Мой последний пост</a></p>
        <p><a href="${pageContext.request.contextPath}/myheroes">Мои персонажи</a></p>
    </div>
</div>

</body>

</html>