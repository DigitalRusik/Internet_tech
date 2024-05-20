<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../img/icon.ico">
    <link rel="stylesheet" type="text/css" href="../css/stylemain.css">
    <title>ТУ- Каталог товаров</title>

    <style>
        td {
            position: relative;
        }
        button {
            color: white;
            background-color: blue;
            border-radius: 6px;
            border: none;
            padding: 10px 20px;
            font-size: 18px;
            margin-right: 10px;
            cursor: pointer;
        }

        .btn-container {
            position: absolute;
            top: 20px;
            right: 20px;
        }
        body {
            margin: 0;
            height: 100%;

        }
        h1 {
            text-align: center;
            margin-top: 50px;
        }
        table {
            margin: 50px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px 20px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        input {
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            font-size: 16px;
        }
        button {
            margin-left: 10px;
            padding: 5px 10px;
            background-color: blue;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover{
            background-color: red;
            text-decoration: none;
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
    <li><a href = "/mainpage/myProducts">Мои товары</a></li>
    <li><a href = "/mainpage/productlist">Каталог товаров</a></li>
    <li><b href = "/mainpage/productsFromUsers">Товары от пользователей</b></li>
    <li><a href = "/mainpage/basket">Корзина</a></li>
    <li><a href = "/mainpage/techSupport">Тех. поддержка</a></li>
</ul>
<form action="/mainpage/productsFromUsers" method="get">
    <p align = "center"><input type="text" name="title" placeholder="Поиск товара">
        <input type="submit" value="Найти"/>
        <a href="/mainpage/productsFromUsers">Сброс</a></p>
<h1>Список товаров от пользователей</h1>
<table id="TablePFU">
    <thead>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Стоимость</th>
        <th>Продавец</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <td>${product.title}</td>
            <td>${product.description}</td>
            <td>${product.price} руб.</td>
            <td>${product.author}</td>
            <td><button onclick="addToCart(this)">Добавить в корзину</button></td>
        </tr>
    <#else>
        <h3>Товары отсутствуют</h3>
    </#list>
    </tbody>
</table>
</body>
<script src="../js/addToCartF.js"></script>
</html>