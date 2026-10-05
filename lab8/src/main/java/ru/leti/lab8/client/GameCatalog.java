package ru.leti.lab8.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import ru.leti.lab8.shared.GameService;
import ru.leti.lab8.shared.GameServiceAsync;

/**
 * Главный клиентский модуль GWT-приложения.
 *
 * Позволяет выбрать пользователя и получить
 * список компьютерных игр из его библиотеки.
 *
 * @author Rodion
 * @version 1.0
 */
public class GameCatalog implements EntryPoint {

    private final GameServiceAsync gameService =
            GWT.create(GameService.class);

    @Override
    public void onModuleLoad() {

        // Заголовок
        HTML title = new HTML(
                "<h1 style='margin-bottom:5px;'>Каталог компьютерных игр</h1>"
        );

        HTML description = new HTML(
                "<div style='color:#666; margin-bottom:20px;'>" +
                        "Просмотр библиотеки игр пользователя" +
                        "</div>"
        );

        // Выбор пользователя
        ListBox users = new ListBox();
        users.addItem("Rodion");
        users.addItem("Alex");
        users.setWidth("250px");

        Button button = new Button("Показать библиотеку");
        button.setWidth("250px");

        VerticalPanel resultPanel = new VerticalPanel();
        resultPanel.setSpacing(5);

        button.addClickHandler(event -> {

            String name = users.getSelectedValue();
            resultPanel.clear();

            gameService.getGames(name, new AsyncCallback<String[]>() {

                @Override
                public void onFailure(Throwable caught) {
                    resultPanel.add(new HTML(
                            "<p style='color:red;'>Ошибка получения данных</p>"
                    ));
                }

                @Override
                public void onSuccess(String[] games) {

                    resultPanel.add(new HTML(
                            "<h2 style='margin-top:25px;'>" +
                                    "Библиотека пользователя " + name +
                                    "</h2>"
                    ));

                    FlexTable table = new FlexTable();

                    table.setText(0, 0, "№");
                    table.setText(0, 1, "Название игры");

                    for (int i = 0; i < games.length; i++) {
                        table.setText(i + 1, 0, String.valueOf(i + 1));
                        table.setText(i + 1, 1, games[i]);
                    }

                    table.setCellPadding(10);
                    table.setCellSpacing(0);
                    table.setWidth("500px");

                    // Оформление заголовка таблицы
                    table.getRowFormatter().getElement(0)
                            .getStyle()
                            .setBackgroundColor("#eeeeee");

                    table.getRowFormatter().getElement(0)
                            .getStyle()
                            .setFontWeight(
                                    com.google.gwt.dom.client.Style.FontWeight.BOLD
                            );

                    resultPanel.add(table);
                }
            });
        });

        // Основной блок страницы
        VerticalPanel mainPanel = new VerticalPanel();
        mainPanel.setSpacing(10);
        mainPanel.setWidth("700px");

        mainPanel.add(title);
        mainPanel.add(description);

        mainPanel.add(new Label("Выберите пользователя:"));
        mainPanel.add(users);
        mainPanel.add(button);

        mainPanel.add(resultPanel);

        // Небольшой отступ от края браузера
        RootPanel.get().getElement()
                .getStyle()
                .setProperty("margin", "40px");

        RootPanel.get().add(mainPanel);
    }
}