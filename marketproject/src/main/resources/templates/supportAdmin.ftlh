<!DOCTYPE html>
<html>
<head>
  <link rel="icon" type="image/x-icon" href="../img/icon.ico">
  <link rel="stylesheet" type="text/css" href="../css/stylemain.css">
  <title>ТУ(адм)- Тех. поддержка</title>
  <style>
    body {
      text-align: center;
    }
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
    <a class="TopHomeLink" href="/adminPage">
      <img class="icon" src="../img/headerUgolok.png" width="220" height="92">
    </a>
  </div>
</header>
<hr>
<ul align = "center">
  <li><a href = "/adminPage">Главная</a></li>
  <li><a href = "/adminPage/userList">Список пользователей</a></li>
  <li><a href = "/adminPage/productAdmin">Список товаров</a></li>
  <li><b href = "/adminPage/supportAdmin">Тех. поддержка</b></li>
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
<form action="/adminPage/supportAdmin/addmsg" method="post">
  <label for="question">Введите ваше сообщение:</label><br>
  <input type="text" id="question" name="question" required><br>
  <label for="receiver">Получатель:</label><br>
  <input type="text" id="receiver" name="receiver" required><br>
  <input type="submit" value="Отправить">
</form>
</body>
</html>