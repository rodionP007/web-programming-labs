<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №3</title>
</head>

<body>

<h1>Каталог компьютерных игр</h1>

<p>Введите имя пользователя:</p>

<form action="catalog" method="get">

    <label>
        Имя:
        <input type="text" name="name">
    </label>

    <button type="submit">
        Показать каталог
    </button>

</form>

</body>
</html>