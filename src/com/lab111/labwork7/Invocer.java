package com.lab111.labwork7;

/**
 * Инициатор посылки сообщения
 *
 */
public class Invocer {
    Invocer(Comand c) {
        comand = c;
    }

    public Comand comand;

    /**
     * выполнить действие
     */
    public void Action() {
        comand.Execute();
    }

    /**
     * изменить команду
     *
     * @param newComand
     *            - новая команда
     */
    public void setComand(Comand newComand) {
        comand = newComand;
    }

}
