<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="models.User"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=windows-1256">
    <title>   User Logged Successfully   </title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="jquery/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <title>??????? ???? "???? ????????"</title>
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="jquery/docs.min.js"></script>
</head>

<body>

<div style="text-align: center;">
    <% User currentUser = (User) (session.getAttribute("currentSessionUser")); %>

    Welcome <%= currentUser.getUsername() + " " %>
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
        ??????? ????
    </h1>
    <h1 align="right" class="header-text2">
        "???? ????????"
    </h1>
</div>

<div>
    <ul id="main-menu" class="nav nav-tabs" align="center">
        <li class="nav-item nav-fill">
            <a class="nav-link" href="#">??? ???????</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" onclick="myFunction(); return false" role="button">????</a>
            <div class="dropdown-menu" id="myDropdown">
                <a class="dropdown-item" href="#">?????</a>
                <a class="dropdown-item" href="#">???????</a>
                <a class="dropdown-item" href="#">?????? ??????????</a>
                <a class="dropdown-item" href="#">???????? ?????????</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">???????</a>
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
    <h3>??? ???????</h3>
</div>

<div class="profile" align="center">
    <div class="about-user" alin="center">
        <p><div class="author"><a href="#">??????????</a></div></p>
        <p><div class="status">? ?? ???? ?????? ?????? ? ??? ?????</div></p>
        <p><img src="???.png" width="180" height="180" class="avatar" align="center"></p>
    </div>
    <div class="posts-user">
        <p><div class="posts-counter">???????? ??????: 249</div></p>
        <p><a href="#">??? ????????? ????</a></p>
        <p><a href="#">??? ?????????</a></p>
    </div>
</div>

</body>

</html>