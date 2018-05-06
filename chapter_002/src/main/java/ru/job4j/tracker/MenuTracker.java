package ru.job4j.tracker;

/**
 * Внешний внутренний класс EditItem.
 */
class EditItem implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id : ");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item.");
    }
}

/**
 * Внешний внутренний класс FindByName.
 */
class FindByName implements UserAction {
    public int key() {
        return 5;
    }
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки, которую нужно найти.");
        Item[] allItems = tracker.findByName(name);
        for (Item item : allItems) {
            if (item != null) {
                System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by name ");
    }
}
/**
 * UserAction - те действия, которые выполняет программа.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = new FindByName();
    }
    /**
     * Метод, который будет выполнять наше действие, которое выбрал пользователь.
     * @param key действие, которое записано в наш массив.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
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
    private  class AddItem implements UserAction {
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Add a new item.");
        }
    }
    /**
     *
     * Внутренний, но уже статический класс ShowItems.
     *
     */
    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {
         for (Item item : tracker.findAll()) {
             if (item != null) {
             System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
             }
         }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Внутренний не статический класс DeleteItem.
     */
    private  class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую следует удалить.");
            tracker.delete(id);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Delete an item.");
        }
    }
    /**
     * Внутренний статический класс FindItemById
     */
    private static class FindItemById implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую нужно найти.");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
            }
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }
    }
}