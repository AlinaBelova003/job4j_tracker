package ru.job4j.tracker;

/**
 * Класс демонстрирует работу шаблона Singeleton - Одиночка
 * Класс final - нельзя наследовать
 */
public final class Log4j {
    private String[] messages = new String[1000];
    private int index = 0;
    /**
     * Статическая переменная для сохранения ссылки на объект
     */
    private static Log4j instanse = null;

    /**
     * Конструктор не даёт создать объект из вне
     */
    private Log4j() {

    }

    /**
     * Создание и возвращение объекта
     */
    public static Log4j getInstance() {
        if (instanse == null) {
            instanse = new Log4j();
        }
        return instanse;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public static void main(String[] args) {
        Log4j log4j = Log4j.getInstance();
        log4j.add("Add new Item");
    }

}
