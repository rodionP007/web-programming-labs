package ru.leti.lab8.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Сервис для получения списка компьютерных игр пользователя.
 */
@RemoteServiceRelativePath("gameService")
public interface GameService extends RemoteService {

    String[] getGames(String username);
}