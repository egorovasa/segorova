package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicContainer<E> implements Iterable<E> {

    private Object[] container;
    private int index = 0;
    private int modCount;

    public DynamicContainer(int size) {
        this.container = new Object[size];
    }

    public void add(E date) {
        if (index == this.container.length) {
            this.container = Arrays.copyOf(this.container, 2 * this.container.length);
            modCount++;
        }
        this.container[index++] = date;
    }

    public E get(int index) {
        return (E) this.container[index];
    }

    public int getSize() {
        return this.container.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < container.length;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[this.i++];
            }
        };
    }
}