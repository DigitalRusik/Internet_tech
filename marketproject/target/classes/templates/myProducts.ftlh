<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="../img/icon.ico">
    <link rel="stylesheet" type="text/css" href="../css/stylemain.css">
    <title>ТУ- Мои товары</title>
    <style>
        input[type="submit"]:hover {
            background-color: red;
        }
    </style>
</head>
<body>
<header>
    <div class="logo">
        <a class="TopHomeLink" href="/mainpage">
            <img class="icon" src="../img/headerUgolok.png" width="220" height="92">
        </a>
    </div>
</header>
<hr>
<ul align = "center">
    <li><a href = "/mainpage">Главная</a></li>
    <li><a href = "/mainpage/addresses">Адреса</a></li>
    <li><b href = "/mainpage/myProducts">Мои товары</b></li>
    <li><a href = "/mainpage/productlist">Каталог товаров</a></li>
    <li><a href = "/mainpage/productsFromUsers">Товары от пользователей</a></li>
    <li><a href = "/mainpage/basket">Корзина</a></li>
    <li><a href = "/mainpage/techSupport">Тех. поддержка</a></li>
</ul>
<form action="/mainpage/myProducts" method="get">
    <p align = "center"><input type="text" name="title" placeholder="Поиск товара">
        <input type="submit" value="Найти"/>
        <a href="/mainpage/myProducts">Сброс</a></p>
</form>
<#list products as product>
<div>
    <p><b>${product.title}</b>${product.price} руб. | <a href="/mainpage/myProducts/${product.id}">Подробнее...</a></p>
</div>
<#else>
<h3>Товары отсутствуют</h3>
</#list>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    <label for="title">Название товара:</label>
    <input type="text" name="title" id="title" required><br><br>

    <label for="description">Описание:</label>
    <input type="text" name="description" id="description" required><br><br>

    <label for="price">Цена:</label>
    <input type="number" name="price" id="price" required><br><br>

    <label for="author">Автор:</label>
    <input type="text" name="author" id="author" value="${username}" readonly><br><br>

    <input type="submit" value="Добавить товар">
</form>
</body>
</html>