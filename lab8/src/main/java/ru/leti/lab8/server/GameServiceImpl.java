package ru.leti.lab8.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.leti.lab8.shared.GameService;

/**
 * Серверная реализация сервиса каталога компьютерных игр.
 *
 * Сервис получает имя пользователя и возвращает
 * список компьютерных игр из его библиотеки.
 *
 * @author Rodion
 * @version 1.0
 */
public class GameServiceImpl extends RemoteServiceServlet
        implements GameService {

    @Override
    public String[] getGames(String username) {

        if ("Rodion".equalsIgnoreCase(username)) {
            return new String[]{
                    "Counter-Strike 2",
                    "Cyberpunk 2077",
                    "Minecraft"
            };
        }

        if ("Alex".equalsIgnoreCase(username)) {
            return new String[]{
                    "Dota 2",
                    "GTA V",
                    "The Witcher 3"
            };
        }

        return new String[]{
                "Игры для пользователя не найдены"
        };
    }
}