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

    public int getIndex(K key) {
        return key.hashCode();
    }

    /**
     * Метод insert нужен для вставки элемента в структуру.
     *
     * @param key   Ключ элемента.
     * @param value Значение элемента.
     * @return true или false, в зависимости от того, удалось добавить объект в структуру или нет.
     */
    public boolean insert(K key, V value) {
        int newIndex = getIndex(key);
        Entry e = table[newIndex];
        boolean rst = false;
        if (e == null) {
            table[newIndex] = new Entry(key, value);
            index++;
            modCount++;
            getSpace();
            rst = true;
        } else {
            if (e.key.equals(key)) {
                e.value = value;
                return true;
            }
        }
        return rst;
    }

    /**
     * Метод get позволяет получить значение объекта по ключу.
     *
     * @param key ключ объекта, который мы хотим увидеть.
     * @return непосредственно значение, value нашего объекта.
     */
    public V get(K key) {
        int newIndex = getIndex(key);
        Entry e = table[newIndex];

        if (e != null) {
            if (e.key.equals(key)) {
                return (V) e.value;
            }
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
        int Index = getIndex(key);
        Entry<K, V> element = table[Index];
        if (element != null && key.equals(element.key)) {
            rst = true;
            table[Index] = null;
            index--;
            modCount--;
        }
        return rst;
    }

    /**
     * Метод getSpace делает массив большего размера, если старый массив переполнен.
     */

    public void getSpace() {
        if (index == this.table.length) {
            Entry newTable[] = new Entry[this.table.length * 2];
            for (Entry element : this.table) {
                if (element != null) {
                    newTable[getIndex((K) element.key)] = element;
                }
            }
            this.table = newTable;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                boolean rst = false;
                int nextCount = count;
                while (nextCount < index) {
                    if (table[nextCount] != null) {
                        rst = true;
                        count = nextCount;
                        break;
                    }
                    nextCount++;
                }
                return rst;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) table[count++].value;
            }
        };
    }
}