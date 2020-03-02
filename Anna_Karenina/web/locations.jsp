<%@ page import="dao.LocationDAO" %>
<%@ page import="models.Location" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 22.11.2019
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
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
        Ролевая Игра
    </h1>
    <h1 align="right" class="header-text2">
        "Анна Каренина"
    </h1>
</div>

<div>
    <ul id="main-menu" class="nav nav-tabs" align="center">
        <li class="nav-item nav-fill">
            <a class="nav-link" href="#">Мой профиль</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" onclick="myFunction(); return false" role="button">Игра</a>
            <div class="dropdown-menu" id="myDropdown">
                <a class="dropdown-item" href="#">Сюжет</a>
                <a class="dropdown-item" href="#">Локации</a>
                <a class="dropdown-item" href="#">Список персонажей</a>
                <a class="dropdown-item" href="#">Создание персонажа</a>
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
    <h3>Обсуждения</h3>
</div>


<div class="location-topic" align="center"><b>Локации:</b></div>
<div class="location-list">
<%
    ArrayList<Location> locations = (ArrayList<Location>) request.getAttribute("locations");
    for (Location location: locations) {
%>
    <div class="location-link">
        <a href="${pageContext.request.contextPath}/locationPage?id=<%= location.getId()%>&title=<%=location.getTitle()%>"><%=location.getTitle()%></a>
        <p>Создано: <%=location.getDate()%></p>
    </div>
<%
    }

%>
</div>

</body>
</html>
