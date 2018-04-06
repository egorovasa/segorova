package ru.job4j.tracker;

import java.util.*;
/**Tracker.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 *
 * @version $Id$
 *
 * @since 0.1
 *
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();
    /**
     *
     * Метод add. Добавление заявок.
     *
     * @param item новая заявка.
     *
     * @return переданную заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     *
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод findById. Получение заявки по Id. проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id.
     *
     * @param id Идентификатор item-а.
     *
     * @return Возвращает найденный Item. Если Item не найден - возвращает null.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод findAll. Получение списка всех заявок.
     *
     * @return Возвращает копию массива this.items без null элементов;
     *
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * Метод replace. Редактирование заявок. Заменяет ячейку в массиве this.items. (Для этого необходимо найти ячейку в массиве по id).
     *
     * @param id Id заявки, которую необходимо заменить.
     *
     * @param item На что необходимо заменить заявку.
     *
     */
    public void replace(String id, Item item) {
            for (int i = 0; i < this.position; i++) {
                if (this.items[i].getId().equals(id)) {
                    this.items[i] = item;
                    break;
                }
            }
    }
    /**
     * Метод delete. Удаление заявок. Удаляет ячейку в массиве this.items. (Для этого необходимо найти ячейку в массиве по id.  Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy()).
     *
     * @param id Идентификатор item-а.
     *
     */
    public void delete(String id) {
        int p = 0;
        for (int k = 0; k < this.position; k++) {
            if (this.items[k].getId().equals(id)) {
                this.items[k] = null;
                p = k;
                break;
            }
        }
        System.arraycopy(this.items, p + 1, this.items, p, this.items.length - p - 1);
    }
    /**
     * Метод findByName. Получение списка по имени. Проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item) с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     *
     * @param key Предположительное имя item-а.
     *
     * @return item, с которым совпало имя.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                result[i] = this.items[i];
                break;
            }
        }
        return result;
    }
}
