package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int i = 0;
    private int[] numbers = new int[i];
    private int size;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
        this.size = numbers.length;
    }

    @Override
    public boolean hasNext() {
        boolean rst = false;
        for (; this.i < this.size; i++) {
            if (this.numbers[i] % 2 == 0) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Integer next() {
        int element = 0;
        if (i > size) {
            throw new NoSuchElementException();
        } else if (hasNext()) {
            element = numbers[i];
            i++;
        }
        return element;
    }
}