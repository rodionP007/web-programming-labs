package ru.leti.lab8.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Асинхронный интерфейс сервиса каталога игр.
 */
public interface GameServiceAsync {

    void getGames(String username, AsyncCallback<String[]> callback);
}