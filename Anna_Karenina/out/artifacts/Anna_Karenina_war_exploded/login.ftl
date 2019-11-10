<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Ролевая игра "Анна Каренина"</title>
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="style.css" type="text/css">
    <script type="text/javascript" rel="script" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
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
        <a class="nav-link" href="#">Мой профиль</a>
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

<div class="page-title" align="center">
    <h3>Вход</h3>
</div>
<div>
    <form action="/login" class="menu" align="center" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleInputEmail1"><b>Логин</b></label>
            <input type="text" name="un" pattern="[a-zA-Z0-9]+" title="Буквы латинского алфавита и цифры" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Введите логин">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"><b>Пароль</b></label>
            <input type="password" name="pw" pattern="[a-zA-Z0-9]+" title="Буквы латинского алфавита и цифры" class="form-control" id="exampleInputPassword1" placeholder="Введите пароль">
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1" align="center">Запомнить меня</label>
        </div>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit" align="center">Войти</button>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" align="center">Регистрация</button>
    </form>
</div>
</body>
</html>