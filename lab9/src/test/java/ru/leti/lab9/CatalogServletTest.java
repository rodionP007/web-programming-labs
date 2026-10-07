package ru.leti.lab9;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CatalogServletTest {

    @Test
    void testCatalogContainsUserName() throws Exception {

        // Создаём поддельные request и response
        HttpServletRequest request =
                mock(HttpServletRequest.class);

        HttpServletResponse response =
                mock(HttpServletResponse.class);

        // Имитируем параметр ?name=Rodion
        when(request.getParameter("name"))
                .thenReturn("Rodion");

        // Буфер, куда сервлет будет выводить HTML
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter())
                .thenReturn(writer);

        // Создаём сервлет
        CatalogServlet servlet = new CatalogServlet();

        // Вызываем doGet без Tomcat
        servlet.doGet(request, response);

        writer.flush();

        String html = stringWriter.toString();

        // Проверяем, что имя появилось в HTML
        assertTrue(html.contains("Rodion"));
    }
}