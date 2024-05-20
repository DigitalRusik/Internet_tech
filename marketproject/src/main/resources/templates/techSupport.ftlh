<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="../img/icon.ico">
    <link rel="stylesheet" type="text/css" href="../css/stylemain.css">
    <title>ТУ- Тех. поддержка</title>
    <style>
        form {
            margin-top: 20px;
        }
        input[type="text"] {
            padding: 10px;
            margin: 10px 0;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: blue;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: red;
        }
        table {
            margin: auto;
            border-collapse: collapse;
            width: 50%;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
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
    <li><a href = "/mainpage/productsFromUsers">Товары от пользователей</a></li>
    <li><a href = "/mainpage/basket">Корзина</a></li>
    <li><b href = "/mainpage/techSupport">Тех. поддержка</b></li>
</ul>
<table>
    <tr>
        <th>Автор</th>
        <th>Сообщение</th>
    </tr>
<#list questions as question>
    <tr>
        <td>${question.writer}</td>
        <td>${question.content}</td>
    </tr>
<#else>
    <h3>Список сообщений пуст.</h3>
</#list>
</table>
<form action="/mainpage/techSupport/addmsg" method="post">
    <label for="question">Введите ваше сообщение:</label>

    <input type="text" id="question" name="question">

    <input type="submit" value="Отправить">
</form>
</body>
</html>