package ru.job4j.tracker;

import org.junit.Test;
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
     *
     * Cоздали StubInput с последовательностью действий.
     *
     * Убедились, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     *
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
     *
     * Добавили в неё заявку.
     *
     * Создали StabInput с последовательностью действий.
     *
     * Создали StartUI и вызвали метод init().
     *
     * Проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     *
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
    @Test
    public void whenShowAllThenAllItems() {

    }
}