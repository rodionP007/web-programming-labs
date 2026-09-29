<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="ru.leti.lab5.Game, java.util.*" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Каталог компьютерных игр</title>
</head>
<body>

<%
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");

    if (name == null) {
%>

<h1>Каталог компьютерных игр</h1>

<form action="Catalog.jsp" method="get">
    <label>
        Имя пользователя:
        <input type="text" name="name">
    </label>

    <button type="submit">Показать каталог</button>
</form>

<%
    } else if (name.trim().isEmpty()) {

        RequestDispatcher dispatcher =
                request.getServletContext()
                       .getRequestDispatcher("/ErrorManager.jsp");

        dispatcher.forward(request, response);
        return;

    } else {

        List<Game> games = new ArrayList<>();

        games.add(new Game(
                "Counter-Strike 2",
                "Шутер",
                "Играет"
        ));

        games.add(new Game(
                "Cyberpunk 2077",
                "RPG",
                "Пройдена"
        ));

        games.add(new Game(
                "Minecraft",
                "Песочница",
                "В библиотеке"
        ));

        request.setAttribute("games", games);
%>

<h2>Список игр пользователя <%= name %></h2>

<jsp:include page="GameList.jsp"/>

<%
    }
%>

</body>
</html>