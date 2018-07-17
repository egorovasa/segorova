package ru.job4j.tracker;

import ru.job4j.tracker.action.MenuTracker;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

import java.util.Arrays;
import java.util.List;

/**StartUI.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 *
 * @version $Id$
 *
 * @since 0.1
 *
 */
public class StartUI {

    private List<Integer> range = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструктор, инициализирующий поля.
     *
     * @param input ввод данных.
     *
     * @param tracker хранилище заявок.
     *
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        boolean exit = false;
        menu.fillActions();
        while(!exit) {
            menu.show();
            menu.select(input.ask("Пожалуйста, выберите нужный пункт.", range));
            if ("6".equals(this.input)) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}