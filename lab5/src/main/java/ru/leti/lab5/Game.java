package ru.leti.lab5;

/**
 * Класс, представляющий компьютерную игру в каталоге.
 *
 * Объект класса Game содержит название игры, её жанр
 * и текущий статус в библиотеке пользователя.
 *
 * @author Rodion
 * @version 1.0
 */
public class Game {

    private String title;
    private String genre;
    private String status;

    /**
     * Создаёт новый объект компьютерной игры.
     *
     * @param title название игры
     * @param genre жанр игры
     * @param status текущий статус игры
     */
    public Game(String title, String genre, String status) {
        this.title = title;
        this.genre = genre;
        this.status = status;
    }

    /**
     * Возвращает название игры.
     *
     * @return название игры
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает жанр игры.
     *
     * @return жанр игры
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Возвращает текущий статус игры.
     *
     * @return статус игры
     */
    public String getStatus() {
        return status;
    }
}