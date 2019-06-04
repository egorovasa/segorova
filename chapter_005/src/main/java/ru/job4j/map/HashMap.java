package ru.job4j.map;

import java.util.*;

/**
 * HashMap.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class HashMap<K, V> implements Iterable<V> {

    private Entry table[];
    private Entry first;
    private int index = 0;
    private int modCount;

    public HashMap(int size) {
        this.table = new Entry[size];
    }

    /**
     * Статический класс Entry для описания элементов структуры.
     *
     * @param <K> ключ элемента.
     * @param <V> значение элемента.
     */
    private static class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K myKey, V myValue) {
            key = myKey;
            value = myValue;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V myValue) {
            this.value = myValue;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K myKey) {
            this.key = myKey;
        }
    }

    public int getSize() {
        return index;
    }

    /**
     * Метод insert нужен для вставки элемента в структуру.
     *
     * @param key   Ключ элемента.
     * @param value Значение элемента.
     * @return true или false, в зависимости от того, удалось добавить объект в структуру или нет.
     */
    public boolean insert(K key, V value) {
        int hash = key.hashCode() % this.table.length;
        Entry e = table[hash];

        if (e != null) {
            if (e.key.equals(key)) {
                e.value = value;
                return true;
            } else {
                return false;
            }
        } else {
            table[hash] = new Entry(key, value);
            index++;
            modCount++;
            return true;
        }
    }

    /**
     * Метод get позволяет получить значение объекта по ключу.
     *
     * @param key ключ объекта, который мы хотим увидеть.
     * @return непосредственно значение, value нашего объекта.
     */
    public V get(K key) {
        int hash = key.hashCode() % this.table.length;
        Entry e = table[hash];

        while (e != null) {
            if (e.key.equals(key)) {
                return (V) e.value;
            }
            e = e.next;
        }
        return null;
    }

    /**
     * Метод delete удаляет элемент.
     *
     * @param key ключ объекта, который нужно удалить.
     * @return true или false, в зависимости от того, удалось удалить элемент или нет.
     */
    public boolean delete(K key) {
        boolean rst = false;
        Entry<K, V> element = table[key.hashCode() % table.length];
        if (element != null) {
            rst = true;
            table[key.hashCode() % table.length] = null;
            index--;
            modCount--;
        }
        return rst;
    }

    /**
     * Метод getSpace делает массив большего размера, если старый массив переполнен.
     */

    public void getSpace() {
        Entry newTable[] = new Entry[this.table.length * 2];
        if (index == this.table.length) {
            for (Entry element : this.table) {
                if (element != null) {
                    int newHash = element.getKey().hashCode() % newTable.length;
                    newTable[newHash] = element;
                }
            }
            this.table = Arrays.copyOf(newTable, newTable.length);
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int expectedModCount = modCount;
            private int count = 0;

            @Override
            public boolean hasNext() {
                boolean rst = false;
                int nextCount = count;
                while (nextCount < index) {
                    if (table[nextCount] != null) {
                        rst = true;
                        break;
                    }
                    count = nextCount;
                }
                return rst;
            }

            @Override
            public V next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (V) table[count++].value;
            }
        };
    }
}