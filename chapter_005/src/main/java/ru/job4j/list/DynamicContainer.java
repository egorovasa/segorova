package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicContainer<E> implements Iterable<E> {

    private Object[] container;
    private int index = 0;
    private int modCount;

    public DynamicContainer(int size) {
        this.container = new Object[size];
    }

    public void add(E data) {
        if (index == this.container.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.container[index++] = data;
        modCount++;
    }

    public void getSpace() {
        if (index == this.container.length) {
            this.container = Arrays.copyOf(this.container, 2 * this.container.length);
        }
    }

    public E get(int index) {
        if (index < this.container.length) {
            return (E) this.container[index];
        }
        return null;
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
                return i < index;
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