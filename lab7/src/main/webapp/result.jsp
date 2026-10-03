<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="java.util.Date" %>

<%
    // Значения по умолчанию
    String username = "Гость";
    String color = "white";

    // Получаем все Cookie, присланные браузером
    Cookie[] cookies = request.getCookies();

    // Ищем среди Cookie имя пользователя и выбранный цвет
    if (cookies != null) {

        for (Cookie cookie : cookies) {

            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }

            if ("color".equals(cookie.getName())) {
                color = cookie.getValue();
            }
        }
    }

    // Получаем данные из Session
    Integer visits =
            (Integer) session.getAttribute("visits");

    Date lastVisit =
            (Date) session.getAttribute("lastVisit");
%>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Результат</title>
</head>

<body style="background-color: <%= color %>">

<h1>Данные пользователя</h1>

<p>
    Имя пользователя:
    <b><%= username %></b>
</p>

<p>
    Значение Cookie color:
    <b><%= color %></b>
</p>

<p>
    Количество обращений:
    <b><%= visits %></b>
</p>

<p>
    Последнее обращение:
    <b>
        <%= lastVisit == null
                ? "Первое посещение"
                : lastVisit %>
    </b>
</p>

<br>

<a href="index.jsp">
    Вернуться
</a>

</body>
</html>