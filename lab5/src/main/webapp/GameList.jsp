<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="ru.leti.lab5.Game, java.util.*" %>

<table border="1" cellpadding="5">
    <tr>
        <th>Название</th>
        <th>Жанр</th>
        <th>Статус</th>
    </tr>

    <%
        List<Game> games =
                (List<Game>) request.getAttribute("games");

        for (Game game : games) {
    %>

    <tr>
        <td><%= game.getTitle() %></td>
        <td><%= game.getGenre() %></td>
        <td><%= game.getStatus() %></td>
    </tr>

    <%
        }
    %>
</table>