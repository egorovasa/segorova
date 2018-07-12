package ru.job4j.tracker;

import java.util.ArrayList;
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
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа, чтобы показать все заявки.
     */
    private static final String SHOW = "1";
    /**
     * Константа, чтобы отредактировать заявку.
     */
    private static final String EDIT = "2";
    /**
     * Константа, чтобы удалить заявку.
     */
    private static final String DEL = "3";
    /**
     * Константа, чтобы найти заявку по Id.
     */
    private static final String FINDID = "4";
    /**
     * Константа, чтобы найти заявку по имени.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    private int[] range = new int[] {0, 1, 2, 3, 4, 5};
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
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    void init() {
        //Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select", range));
        } while (!"6".equals(this.input.ask("Exit? (6) : ")));
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод печатает все заявки.
     */
    private void showItem() {
        System.out.println("------------ Все заявки --------------");
        System.out.println("------------ Результат :-----------");
        List<Item> allItems = this.tracker.findAll();
        for (Item item : allItems) {
            if (item != null) {
            System.out.println("ID: " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDescription());
            }
        }
    }
    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------ Редактирование существующей заявки --------------");
        String id = this.input.ask("Введите id заявки, которую нужно отредактировать.");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Заявка отредактирована. ID:  " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDescription() + "-----------");
    }
    /**
     * Метод реализует удаление существующей заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление существующей заявки --------------");
        String id = this.input.ask("Введите id заявки, которую следует удалить.");
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена.-----------");
    }
    /**
     * Метод реализует поиск заявки по id.
     */
    private void findIdItem() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки, которую нужно найти.");
        System.out.println("------------ Результат : -----------");
        Item item = this.tracker.findById(id);
        System.out.println("ID заявки: " + item.getId() + " Имя заявки: " + item.getName() + " Описание: " + item.getDescription());
    }
    /**
     * Метод реализует поиск заявок по имени.
     */
    private void findNameItem() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки, которую нужно найти.");
        System.out.println("------------ Результат : -----------");
        List<Item> allItems = this.tracker.findByName(name);
        for (Item item : allItems) {
            if (item != null) {
                System.out.println("ID: " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDescription());
            }
        }
    }
    /**
     * Метод выводит меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}