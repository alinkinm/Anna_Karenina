<%@ page language="java"
         contentType="text/html; charset=cp1251"
         pageEncoding="cp1251"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>������� ���� "���� ��������"</title>
    <link rel="shortcut icon" href="icon.ico.png" type="image/x-icon">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="style.css" type="text/css">
    <script rel="script" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="javascript"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=cp1251">
    <title>Login Page</title>
</head>

<body>
<script type="javascript">
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
        ������� ����
    </h1>
    <h1 align="right" class="header-text2">
        "���� ��������"
    </h1>
</div>

<ul id="main-menu" class="nav nav-tabs" align="center">
    <li class="nav-item nav-fill">
        <a class="nav-link" href="#">��� �������</a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" onclick="myFunction(); return false" role="button">����</a>
        <div class="dropdown-menu" id="myDropdown">
            <a class="dropdown-item" href="#">�����</a>
            <a class="dropdown-item" href="#">�������</a>
            <a class="dropdown-item" href="#">������ ����������</a>
            <a class="dropdown-item" href="#">����� ���������</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">�������</a>
    </li>
    <li>
        <form class="form-inline my-2 my-lg-0" >
            <input class="form-control mr-sm-2" type="search" placeholder="�����" aria-label="Search" id="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">�����</button>
        </form>
    </li>
</ul>
</div>
</div>

<div class="page-title" align="center">
    <h3>����</h3>
</div>
<div>
    <form class="menu" align="center" action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1"><b>�����</b></label>
            <input type="text" name="un" pattern="[a-zA-Z0-9]+" title="����� ���������� �������� � �����" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="������� �����">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"><b>������</b></label>
            <input type="password" name = "pw" pattern="[a-zA-Z0-9]+" title="����� ���������� �������� � �����" class="form-control" id="exampleInputPassword1" placeholder="������� ������">
        </div>
        <% String s1  = (String) session.getAttribute("errorMessage");%>
        <% if(s1 != null){ %>
        <div class="besideemailbox" style="color : red">Invalid userName or Password</div>
        <% }%>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1" align="center">��������� ����</label>
        </div>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit" align="center">�����</button>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" align="center">�����������</button>
    </form>
</div>
</body>

</body>
</html>