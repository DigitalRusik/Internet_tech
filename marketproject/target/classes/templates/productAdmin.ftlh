<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../img/icon.ico">
    <link rel="stylesheet" type="text/css" href="../css/stylemain.css">
    <title>ТУ(Адм.)- Список товаров</title>
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
    <li><a href = "/adminPage/userList">Список пользователей</a></li>
    <li><b href = "/adminPage/productAdmin">Список товаров</b></li>
    <li><a href = "/adminPage/supportAdmin">Тех. поддержка</a></li>
</ul>
<form action="/adminPage/productAdmin" method="get">
    <p align = "center"><input type="text" name="title" placeholder="Поиск товара">
        <input type="submit" value="Найти"/>
    <a href="/adminPage/productAdmin">Сброс</a></p>
</form>
<#list products as product>
<div>
    <li><b>${product.title}</b><br>
    <li>Идентификатор: ${product.id}</li><br>
    <li>Цена: ${product.price} руб.</li><br>
    <li>Описание: ${product.description}</li><br>
    <li>Автор: ${product.author}</li>
    <form action="/adminPage/productAdmin/delete/${product.id}" method="post">
        <input type="submit" value="Удалить товар"/>
    </form>
</div><br>
<#else>
<h3>Товары отсутствуют</h3>
</#list>
</body>
</html>