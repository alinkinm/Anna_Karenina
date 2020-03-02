<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 11.11.2019
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=cp1251" language="java" pageEncoding="cp1251"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Создание персонажа</title>
    <meta http-equiv="Content-Type" content="text/html; charset=cp1251">
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="style.css" type="text/css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" type="text/javascript"></script>
    <script type="javascript">window.jQuery || document.write('<script src="/jquery/jquery.slim.min.js"><\/script>')</script>
    <script type="javascript" src="bootstrap/js/bootstrap.bundle.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
    <script type="javascript" src="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.js"></script>
    <script type="javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="javascript" src="jquery/jquery.min.js"></script>
    <script type="javascript" src="jquery/jquery.slim.min.js"></script>
    <script type="javascript" src="bootstrap/js/bootstrap.bundle.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
    <script type="javascript" src="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.js"></script>
    <script type="javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
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
<script type="text/javascript">
    function countChars(countfrom,displayto) {
        document.getElementById(displayto).innerHTML = document.getElementById(countfrom).value.length;
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
            <a class="nav-link dropdown-toggle" onclick="myFunction(); return false" href="#" role="button">Игра</a>
            <div class="dropdown-menu" id="myDropdown">
                <a class="dropdown-item" href="#">Сюжет</a>
                <a class="dropdown-item" href="#">Локации</a>
                <a class="dropdown-item" href="#">Список персонажей</a>
                <a class="dropdown-item" href="#">Выбор персонажа</a>
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
    <h3>Создание персонажа</h3>
</div>
<form class="menu" align="center" action="${pageContext.request.contextPath}/createhero" method="post" enctype="multipart/form-data">
    <p>
    <div class="form-group">
        <label for="exampleInputEmail1"><b>Введите имя персонажа</b></label>-->
        <label for="nameInput"><b>Введите имя персонажа</b></label><input type="text" name="heroname" class="form-control" id="nameInput" aria-describedby="emailHelp" placeholder="Введите имя">
    </div>
    <div class="form-group">
        <!--<label for="exampleInputEmail1"><b>Выберите пол</b></label>-->
        <label> <b>Выберите пол</b>
            <select class="form-control">
                <option>Женский</option>
                <option>Мужской</option>
            </select>
        </label>
    </div>
    <div class="form-group">
        <label for="exampleFormControlFile1"><b>Фото</b></label>
        <input type="file" name="photo" class="form-control-file btn btn-outline-success my-2 my-sm-0" id="exampleFormControlFile1">
    </div>
    <div class="form-group">
        <!--<label for="exampleFormControlTextarea1"><b>О персонаже</b></label>-->
        <label for="data"><b>О персонаже</b></label><textarea name="desc" class="form-control" id="data" rows="3" onkeyup="countChars('data','charcount');" onkeydown="countChars('data','charcount');" onmouseout="countChars('data','charcount');"></textarea>
        Введено символов: <span id="charcount">0</span>
    </div>
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" align="center">Создать персонажа</button>
</form>


</body>
</html>
