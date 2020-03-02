<%@ page import="models.User" %>
<%@ page import="dao.HeroDAO" %>
<%@ page import="models.Hero" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.PostDAO" %><%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 19.11.2019
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=cp1251" language="java" pageEncoding="cp1251" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="cp1251">
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
            <a class="nav-link" href="${pageContext.request.contextPath}/profile">Мой профиль</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" onclick="myFunction(); return false" role="button">Игра</a>
            <div class="dropdown-menu" id="myDropdown">
                <a class="dropdown-item" href="#">Сюжет</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/location">Локации</a>
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
    <h3>Мои персонажи</h3>
</div>


<%  User user  = (User) session.getAttribute("currentSessionUser");
    PostDAO dao;
    for (Hero hero: (ArrayList<Hero>)session.getAttribute("heroes")) {
       session.setAttribute("currentHero", hero.getName());
       session.setAttribute("heroDesc", hero.getDescription());
       String name = (String)session.getAttribute("currentHero");
       String description = (String)session.getAttribute("heroDesc");

    %>
<div class="profile">
    <div class="about-user" alin="center">
        <p><div class="author"><a href="#"><%= name %></a></div></p>

        <p><img src="<%= hero.getPhoto()%>" width="180" height="180" class="avatar" align="center"></p>
    </div>
    <div class="posts-user">
        <p><div class="posts-counter">Написано постов: <%
        long k = hero.getId();
        dao = new PostDAO();
        int y = dao.number(k);
    %><%=y%></div></p>
        <p><a href="#">Последний пост</a></p>
        <p><a href="#" data-toggle="modal" data-target="#description" onclick="return false" role="button">Описание персонажа</a></p>
    </div>
</div>
<div class="modal fade" id="description" tabindex="-1" role="dialog" aria-labelledby="description" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalScrollableTitle"><%=name%></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <%= description %>
            </div>
        </div>
    </div>
</div>
<%  }
    %>
</body>
</html>
