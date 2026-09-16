package ru.leti.lab3;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет для отображения каталога компьютерных игр.
 *
 * Сервлет получает имя пользователя из параметра HTTP-запроса
 * и формирует HTML-страницу со списком компьютерных игр.
 * Название каталога задаётся параметром инициализации сервлета.
 *
 * @author Rodion
 * @version 1.0
 */

public class CatalogServlet extends HttpServlet {

    private String catalogTitle;

    /**
     * Инициализирует сервлет и получает название каталога
     * из параметра инициализации catalogTitle.
     *
     * @param config конфигурация сервлета
     * @throws ServletException при ошибке инициализации сервлета
     */

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        catalogTitle = config.getInitParameter("catalogTitle");
    }

    /**
     * Обрабатывает GET-запрос пользователя и формирует
     * HTML-страницу с каталогом компьютерных игр.
     *
     * @param request HTTP-запрос клиента
     * @param response HTTP-ответ сервера
     * @throws IOException при ошибке ввода-вывода
     */

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            name = "Гость";
        }

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>" + catalogTitle + "</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>" + catalogTitle + "</h1>");
        out.println("<h2>Пользователь: " + name + "</h2>");

        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Название</th>");
        out.println("<th>Жанр</th>");
        out.println("<th>Статус</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Counter-Strike 2</td>");
        out.println("<td>Шутер</td>");
        out.println("<td>Играет</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Cyberpunk 2077</td>");
        out.println("<td>RPG</td>");
        out.println("<td>Пройдена</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Minecraft</td>");
        out.println("<td>Песочница</td>");
        out.println("<td>В библиотеке</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}