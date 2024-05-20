<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../img/icon.ico">
    <link rel="stylesheet" type="text/css" href="../css/stylemain.css">
    <title>ТУ(Адм.)- Список пользователей</title>
</head>
<body>
<header>
    <div class="logo">
        <a class="TopHomeLink" href="/adminPage">
            <img class="icon" src="../img/headerUgolok.png" width="220" height="92">
        </a>
    </div>
</header>
<hr>
<ul align = "center">
    <li><a href = "/adminPage">Главная</a></li>
    <li><b href = "/adminPage/userList">Список пользователей</b></li>
    <li><a href = "/adminPage/productAdmin">Список товаров</a></li>
    <li><a href = "/adminPage/supportAdmin">Тех. поддержка</a></li>
</ul>
<form action="/adminPage/userList" method="get">
    <p align = "center"><input type="text" name="username" placeholder="Поиск пользователя">
        <input type="submit" value="Найти"/>
        <a href="/adminPage/userList">Сброс</a>
    </p>
</form>
<#list users as user>
<div>
    <li>Имя пользователя: ${user.name}<br>
    <li>ID пользователя: ${user.id}<br>
    <li>Электронная почта: ${user.email}</li><br>
    <li>Ключ: ${user.passkey}</li><br>
    <li>Пароль: ${user.password}</li><br>
    <form action="/adminPage/userList/delete/${user.id}" method="post">
        <input type="submit" value="Удалить пользователя"/>
    </form>
</div><br>
<#else>
<h3>Пользователи отсутствуют</h3>
</#list>
</body>
</html>