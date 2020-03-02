<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Hero" %>
<%@ page import="models.User" %>
<%@ page import="dao.HeroDAO" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="models.Post" %>
<%@ page import="dao.UserDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 23.11.2019
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Ролевая игра "Анна Каренина"</title>
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown-toggle").dropdown();
        });
    </script>
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
<script type="text/javascript">
    function countChars(countfrom,displayto) {
        var len = document.getElementById(countfrom).value.length;
        document.getElementById(displayto).innerHTML = len;
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
            <a class="nav-link dropdown-toggle something" href="#" onclick="myFunction(); return false" role="button">Игра</a>
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
    <h3><%=request.getAttribute("title")%></h3>
</div>

<% String slocationId = (String) request.getAttribute("locId");
int locationId = Integer.parseInt(slocationId);
    PostDAO pd = new PostDAO();
    ArrayList<Post> allPosts = (ArrayList<Post>) pd.getFromLocation(locationId);
    String author;
    String date;
    String content;
    UserDAO daoshka = new UserDAO();
    for (Post post: allPosts) {
        author = (daoshka.get(post.getAuthorID())).getUsername();
        %>
<br>
       <div class="post-box" style=" width: 90%">
    <div class="post-time">
                 <%=post.getDate()%>
                </div>
    <div class="post-author">
        <ul>
            <p><div class="author"><a href="#"><%=post.getHeroName()%></a></div></p>

            <p><img src="аня.png" width="180" height="180" class="avatar" align="center"></p>
            <p><div class="posts-counter">Сообщений: 249</div></p>
        </ul>
    </div>


    <div class="post-body">
        <div id="p193244-content" class="post-content">
                <%=post.getText()%>
            <p><a href="${pageContext.request.contextPath}/answer?komuNahuy=<%=post.getHeroName()%>&id=<%=request.getAttribute("locId")%>&title=<%=request.getAttribute("title")%>" class="reply-a">Ответить</a></p>
        </div>
    </div>

       </div>
<br>



<%
    }

%>


<form class="new-post" align="center" action="${pageContext.request.contextPath}/newPost?id=<%=request.getAttribute("locId")%>&title=<%=request.getAttribute("title")%>" method="post">
    <h5 сlass="np-title">Новый пост</h5>
    <p></p>
    <select name="heroName" class="form-control">
        <%
            User user = (User)session.getAttribute("currentSessionUser");
            HeroDAO hd = new HeroDAO();
            ArrayList<Hero> heroes = hd.get2(user.getId());
            for (Hero hero: heroes) {
        %>
        <option value="<%=hero.getName()%>"><%=hero.getName()%></option>
        <% } %>
    </select>

    <div class="form-group">
        <p></p>
        <textarea name="content" class="form-control" id="data" rows="3" onkeyup="countChars('data','charcount');" onkeydown="countChars('data','charcount');" onmouseout="countChars('data','charcount');">
            <%=request.getAttribute("komuNahuy")%>
        </textarea>
        Введено символов: <span id="charcount">0</span>

    </div>
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" align="center">Отправить</button>
</form>


</body>
</html>