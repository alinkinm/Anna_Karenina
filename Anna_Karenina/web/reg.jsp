<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 18.11.2019
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">

    <title>Ролевая игра "Анна Каренина"</title>
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="style.css">
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

<ul id="main-menu" class="nav nav-tabs" align="center">
    <li class="nav-item nav-fill">
        <a class="nav-link" href="${pageContext.request.contextPath}/profile">Мой профиль</a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" onclick="myFunction(); return false" role="button">Игра</a>
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
</div>
<script type="text/javascript">
    var check = function() {
        if (document.getElementById('password').value ===
            document.getElementById('confirm_password').value) {
            document.getElementById('message').style.color = '#eea6a6';
            document.getElementById('message').innerHTML = 'Пароли совпадают ✓';
        } else if (document.getElementById('password').value == "" &&
            document.getElementById('confirm_password').value === "") {
            document.getElementById('message').style.color = '#f09f9f';
            document.getElementById('message').innerHTML = 'Введите пароль';
        } else {
            document.getElementById('message').style.color = '#f09f9f';
            document.getElementById('message').innerHTML = 'Пароли не совпадают ☒';
        }
    }
</script>
<script type="text/javascript">
    function countChars(countfrom,displayto) {
        var len = document.getElementById(countfrom).value.length;
        document.getElementById(displayto).innerHTML = len;
    }
</script>
<div class="page-title" align="center">
    <h3>Регистрация</h3>
</div>
<div>
    <form class="menu" align="center" action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleInputEmail1"><b>Логин</b></label>
            <input type="text" name="username" pattern="[a-zA-Z0-9]+" title="Буквы латинского алфавита и цифры" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Введите логин">
        </div>
        <!--<div class="form-group">
            <label for="exampleInputEmail1"><b>Имя</b></label>
            <input type="text" name="firstname" pattern="[а-яА-Я]+" title="Буквы кириллицы" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Введите имя">
        </div> -->
        <div class="form-group">
            <%--@declare id="exampleinputpassword1"--%><label for="exampleInputPassword1"><b>Пароль</b></label>
            <input type="password" name="password" pattern="[a-zA-Z0-9]+" title="Буквы латинского алфавита и цифры" class="form-control" id="password" placeholder="Введите пароль" onkeyup='check();'>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"><b>Повторите пароль</b></label>
            <input type="password" name="password1" pattern="[a-zA-Z0-9]+" title="Буквы латинского алфавита и цифры" class="form-control" id="confirm_password" placeholder="Повторите пароль" onkeyup='check();'>
            <span id='message'></span>
        </div>
        <div class="form-group">
            <label for="exampleFormControlFile1"><b>Фото</b></label>
            <input type="file" name="photo" class="form-control-file btn btn-outline-success my-2 my-sm-0" id="exampleFormControlFile1">
        </div>
        <div class="form-group">
            <%--@declare id="exampleformcontroltextarea1"--%><label for="exampleFormControlTextarea1"><b>О себе</b></label>
            <textarea class="form-control" name="about" id="data" rows="3" onkeyup="countChars('data','charcount');" onkeydown="countChars('data','charcount');" onmouseout="countChars('data','charcount');"></textarea>
            Введено символов: <span id="charcount">0</span>
        </div>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" align="center">Вход</button>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" align="center">Зарегистрироваться</button>
        <% String s1  = (String) session.getAttribute("errorMessage");%>
        <% if(s1 != null){ %>
        <div class="besideemailbox" style="color : red">Пользователь c таким логином уже существует</div>
        <% }%>
    </form>
</div>



<script type="text/javascript" src="jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="jquery/docs.min.js"></script>
</body>
</html>
