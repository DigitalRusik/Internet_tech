<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="../../img/icon.ico">
    <link rel="stylesheet" type="text/css" href="../../css/stylemain.css">
    <title>ТУ- Информация о товаре</title><br>
</head>
<body>
<header>
    <div class="logo">
        <a class="TopHomeLink" href="/mainpage">
            <img class="icon" src="../../img/headerUgolok.png" width="220" height="92">
        </a>
    </div>
</header>
<hr>
<ul align = "center">
    <li><a href = "/mainpage">Главная</a></li>
    <li><a href = "/mainpage/addresses">Адреса</a></li>
    <li><a href = "/mainpage/myProducts">Мои товары</a></li>
    <li><a href = "/mainpage/productlist">Каталог товаров</a></li>
    <li><a href = "/mainpage/productsFromUsers">Товары от пользователей</a></li>
    <li><a href = "/mainpage/basket">Корзина</a></li>
    <li><a href = "/mainpage/techSupport">Тех. поддержка</a></li>
</ul>
<h3>Подробная информация о товаре</h3>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/> <br><br>
</#list>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price} Руб.<br>
<b>Автор: </b>${product.author}<br>
<hr>
<form action="/mainpage/myProducts/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>