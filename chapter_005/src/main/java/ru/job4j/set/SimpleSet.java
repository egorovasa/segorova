package ru.job4j.set;

import ru.job4j.list.DynamicContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleSet<E> {
    private DynamicContainer<E> set = new DynamicContainer<>(5);

    public void add(E data) {
        boolean result = true;
        for (E e : set) {
            if (data == e) {
                result = false;
                break;
            }
        }
        if (result) {
            set.add(data);
        }
    }

    public E get(int index) {
        return set.get(index);
    }
}