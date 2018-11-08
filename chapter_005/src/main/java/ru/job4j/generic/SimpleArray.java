package ru.job4j.generic;

import java.util.*;

public class SimpleArray<T> implements Iterator {

    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        if (index == this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[index++] = model;
    }

    @SuppressWarnings("unchecked")
    public T get(int p) {
        return (T) this.objects[p];
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void delete(int i) {
        System.arraycopy(this.objects, i + 1, this.objects, i, this.objects.length - i - 1);
        this.objects[this.objects.length - 1] = null;
    }

    @Override
    public boolean hasNext() {
        return this.objects.length > index;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        return (T) this.objects[index++];
    }
}