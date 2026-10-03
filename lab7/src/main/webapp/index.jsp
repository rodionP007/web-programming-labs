<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="java.util.Date" %>

<%
    request.setCharacterEncoding("UTF-8");

    // Проверяем, была ли отправлена форма
    if ("POST".equalsIgnoreCase(request.getMethod())) {

        // Получаем введённые пользователем данные
        String username = request.getParameter("username");
        String color = request.getParameter("color");

        // Создаём Cookie для имени пользователя и цвета страницы
        Cookie userCookie = new Cookie("username", username);
        Cookie colorCookie = new Cookie("color", color);

        // Cookie будут храниться в браузере один час
        userCookie.setMaxAge(60 * 60);
        colorCookie.setMaxAge(60 * 60);

        // Добавляем Cookie в HTTP-ответ
        response.addCookie(userCookie);
        response.addCookie(colorCookie);

        // Получаем количество предыдущих обращений из Session
        Integer visits = (Integer) session.getAttribute("visits");

        if (visits == null) {
            visits = 0;
        }

        visits++;

        // Получаем время текущего посещения,
        // сохранённое при предыдущем обращении
        Date previousVisit =
                (Date) session.getAttribute("currentVisit");

        // Сохраняем данные в Session
        session.setAttribute("visits", visits);
        session.setAttribute("lastVisit", previousVisit);
        session.setAttribute("currentVisit", new Date());

        // Перенаправляем браузер на вторую JSP-страницу
        // Новый запрос уже будет содержать созданные Cookie
        response.sendRedirect("result.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №7</title>
</head>

<body>

<h1>Настройки пользователя</h1>

<form action="index.jsp" method="post">

    <label>
        Имя пользователя:
        <input type="text"
               name="username"
               required>
    </label>

    <br><br>

    <label>
        Цвет страницы:

        <select name="color">
            <option value="white">Белый</option>
            <option value="lightblue">Голубой</option>
            <option value="lightgreen">Зелёный</option>
            <option value="lightyellow">Жёлтый</option>
        </select>
    </label>

    <br><br>

    <button type="submit">
        Продолжить
    </button>

</form>

</body>
</html>