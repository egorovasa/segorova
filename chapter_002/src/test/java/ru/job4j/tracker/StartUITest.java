package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**StartUITest.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 *
 * @version $Id$
 *
 * @since 0.1
 *
 */
public class StartUITest {
    /**
     * Создали Tracker.
     * <p>
     * Cоздали StubInput с последовательностью действий.
     * <p>
     * Убедились, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Создали Tracker.
     * <p>
     * Добавили в неё заявку.
     * <p>
     * Создали StabInput с последовательностью действий.
     * <p>
     * Создали StartUI и вызвали метод init().
     * <p>
     * Проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Тест проверяет удаление заявки.
     */
    @Test
    public void whenDeleteItemThenLeftShift() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Item item1 = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(item1.getName()));
    }

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тест проверяет вывод всех заявок.
     */
    @Test
    public void whenShowAllThenAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню." + "\r\n")
                                .append("0. Add new Item" + "\r\n")
                                .append("1. Show all items" + "\r\n")
                                .append("2. Edit item" + "\r\n")
                                .append("3. Delete item" + "\r\n")
                                .append("4. Find item by Id" + "\r\n")
                                .append("5. Find items by name" + "\r\n")
                                .append("6. Exit Program" + "\r\n")
                                .append("------------ Все заявки --------------" + "\r\n")
                                .append("------------ Результат :-----------" + "\r\n")
                                .append("ID: " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDescription() + "\r\n")
                                .append("Меню." + "\r\n")
                                .append("0. Add new Item" + "\r\n")
                                .append("1. Show all items" + "\r\n")
                                .append("2. Edit item" + "\r\n")
                                .append("3. Delete item" + "\r\n")
                                .append("4. Find item by Id" + "\r\n")
                                .append("5. Find items by name" + "\r\n")
                                .append("6. Exit Program" + "\r\n")
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Тест проверяет нахождение заявки по id.
     */
    @Test
    public void whenFindByIDThenFindAnItemWithSameId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню." + "\r\n")
                                .append("0. Add new Item" + "\r\n")
                                .append("1. Show all items" + "\r\n")
                                .append("2. Edit item" + "\r\n")
                                .append("3. Delete item" + "\r\n")
                                .append("4. Find item by Id" + "\r\n")
                                .append("5. Find items by name" + "\r\n")
                                .append("6. Exit Program" + "\r\n")
                                .append("------------ Поиск заявки по id --------------" + "\r\n")
                                .append("------------ Результат : -----------" + "\r\n")
                                .append("ID заявки: " + item.getId() + " Имя заявки: " + item.getName() + " Описание: " + item.getDescription() + "\r\n")
                                .append("Меню." + "\r\n")
                                .append("0. Add new Item" + "\r\n")
                                .append("1. Show all items" + "\r\n")
                                .append("2. Edit item" + "\r\n")
                                .append("3. Delete item" + "\r\n")
                                .append("4. Find item by Id" + "\r\n")
                                .append("5. Find items by name" + "\r\n")
                                .append("6. Exit Program" + "\r\n")
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Тест проверяет поиск заявки по имени.
     */
    @Test
    public void whenFindByNameThenFindItemsWithSameName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню." + "\r\n")
                                .append("0. Add new Item" + "\r\n")
                                .append("1. Show all items" + "\r\n")
                                .append("2. Edit item" + "\r\n")
                                .append("3. Delete item" + "\r\n")
                                .append("4. Find item by Id" + "\r\n")
                                .append("5. Find items by name" + "\r\n")
                                .append("6. Exit Program" + "\r\n")
                                .append("------------ Поиск заявки по имени --------------" + "\r\n")
                                .append("------------ Результат : -----------" + "\r\n")
                                .append("ID: " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDescription() + "\r\n")
                                .append("Меню." + "\r\n")
                                .append("0. Add new Item" + "\r\n")
                                .append("1. Show all items" + "\r\n")
                                .append("2. Edit item" + "\r\n")
                                .append("3. Delete item" + "\r\n")
                                .append("4. Find item by Id" + "\r\n")
                                .append("5. Find items by name" + "\r\n")
                                .append("6. Exit Program" + "\r\n")
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}