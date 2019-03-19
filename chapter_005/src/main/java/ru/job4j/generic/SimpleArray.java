package ru.job4j.generic;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Метод add добавляет указанный элемент в первую свободную ячейку.
     *
     * @param model указанный элемент.
     */
    public void add(T model) {
        if (index == this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[index++] = model;
    }

    /**
     * Метод get возвращает элемент, расположенный по указанному индексу index.
     *
     * @param index индекс.
     * @return элемент, расположенный по индексу index.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.objects[index];
    }

    /**
     * Метод set заменяет указанным элементом (@param model) элемент, находящийся по индексу index.
     *
     * @param index индекс.
     * @param model указанный элемент.
     */
    public void set(int index, T model) {
        if (index > this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[index] = model;
    }

    /**
     * Метод delete удаляет элемент по указанному индексу index, (при этом все элементы, находящиеся справа, сдвигаются на единицу влево).
     *
     * @param index индекс.
     */
    public void delete(int index) {
        if (index > this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - index - 1);
        this.objects[this.objects.length - 1] = null;
    }

    /**
     * Mетод iterator() возвращает итератор, предназначенный для обхода данной структуры.
     *
     * @return итератор, предназначенный для обхода данной структуры.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return this.i < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[this.i++];
            }
        };
    }
}