package ru.leti.lab4;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Сервлет для отображения локализованного каталога компьютерных игр.
 *
 * Сервлет получает имя пользователя и выбранный язык из параметров
 * HTTP-запроса. В зависимости от выбранного языка создаётся объект Locale
 * и загружается соответствующий набор ресурсов с помощью ResourceBundle.
 * После этого сервлет формирует HTML-страницу каталога на выбранном языке.
 *
 * @author Rodion
 * @version 1.0
 */
public class CatalogServlet extends HttpServlet {

    /**
     * Обрабатывает GET-запрос пользователя и формирует локализованную
     * HTML-страницу с каталогом компьютерных игр.
     *
     * Параметр name содержит имя пользователя, а параметр lang
     * определяет язык интерфейса.
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

        String lang = request.getParameter("lang");

        Locale locale;

        if ("en".equals(lang)) {
            locale = Locale.ENGLISH;
        } else {
            locale = new Locale("ru");
        }

        ResourceBundle resources =
                ResourceBundle.getBundle("messages", locale);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>" + resources.getString("catalog.title") + "</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>" + resources.getString("catalog.title") + "</h1>");
        out.println("<h2>" + resources.getString("user") + ": " + name + "</h2>");

        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>" + resources.getString("game.title") + "</th>");
        out.println("<th>" + resources.getString("game.genre") + "</th>");
        out.println("<th>" + resources.getString("game.status") + "</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>" + resources.getString("game.cs2.title") + "</td>");
        out.println("<td>" + resources.getString("game.cs2.genre") + "</td>");
        out.println("<td>" + resources.getString("game.cs2.status") + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>" + resources.getString("game.cyberpunk.title") + "</td>");
        out.println("<td>" + resources.getString("game.cyberpunk.genre") + "</td>");
        out.println("<td>" + resources.getString("game.cyberpunk.status") + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>" + resources.getString("game.minecraft.title") + "</td>");
        out.println("<td>" + resources.getString("game.minecraft.genre") + "</td>");
        out.println("<td>" + resources.getString("game.minecraft.status") + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}