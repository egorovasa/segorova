package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * TrackerTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 *
 */
public class TrackerTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        // Добавляем заявку в трекер. Теперь объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenIdThenItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenNameThenItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Item[] result = new Item[1];
        result[0] = item;
        assertThat(tracker.findByName(item.getName()), is(result));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteThenNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription");
        Item secondItem = new Item("test2", "testDescription2");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.delete(firstItem.getId());
        assertThat(tracker.findAll()[0], is(secondItem));
    }

    /**
     * Test findAll.
     */
    @Test
    public void whenAllThenArrayWithoutNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription");
        Item secondItem = new Item("test2", "testDescription2");
        tracker.add(firstItem);
        tracker.add(secondItem);
        Item[] expected = {firstItem, secondItem};
        assertThat(tracker.findAll(), is(expected));
    }
}