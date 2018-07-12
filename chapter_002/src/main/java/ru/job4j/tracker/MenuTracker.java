package ru.job4j.tracker;
import java.util.List;
/**
 * Внешний внутренний класс EditItem.
 */
class EditItem extends BaseAction {
    EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id : ");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
    }
}
/**
 * Внешний внутренний класс FindByName.
 */
class FindByName extends BaseAction {
    FindByName(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки, которую нужно найти.");
        List<Item> allItems = tracker.findByName(name);
        for (Item item : allItems) {
            if (item != null) {
                System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }
}
/**
 * UserAction - те действия, которые выполняет программа.
 */
class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    private int position = 0;
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод fillActions, заполняет наши данные.
     */
    void fillActions() {
        this.actions[position++] = this.new AddItem(0, "Add an item.");
        this.actions[position++] = new MenuTracker.ShowItems(1, "Show all items.");
        this.actions[position++] = new EditItem(2, "Edit item.");
        this.actions[position++] = this.new DeleteItem(3, "Delete an item.");
        this.actions[position++] = new MenuTracker.FindItemById(4, "Find an Item by ID.");
        this.actions[position++] = new FindByName(5, "Find items by name.");
    }
    /**
     * Метод, который будет выполнять наше действие, которое выбрал пользователь.
     * @param key действие, которое записано в наш массив.
     */
    void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
            System.out.println(action.info());
            }
        }
    }
    /**
     * Внутренний класс AddItem.
     * Он не статический.
     *
     */
    private  class AddItem extends BaseAction {
        AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }
    /**
     *
     * Внутренний, но уже статический класс ShowItems.
     *
     */
    private static class ShowItems extends BaseAction {
        ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
         for (Item item : tracker.findAll()) {
             if (item != null) {
             System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
             }
         }
        }
    }
    /**
     * Внутренний не статический класс DeleteItem.
     */
    private  class DeleteItem extends BaseAction {
        DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую следует удалить.");
            tracker.delete(id);
        }
    }
    /**
     * Внутренний статический класс FindItemById
     */
    private static class FindItemById extends BaseAction {
        FindItemById(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую нужно найти.");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
            }
    }
}