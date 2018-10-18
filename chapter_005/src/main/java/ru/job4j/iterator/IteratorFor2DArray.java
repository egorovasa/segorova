package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFor2DArray implements Iterator {

    private int[][] data;
    private int i, j;

    public IteratorFor2DArray(int[][] data) {
        this.data = data;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int element = data[i][j];
        j++;
        while (i < data.length && j >= data[i].length) {
            j = 0;
            i++;
        }
        return element;
    }

    @Override
    public boolean hasNext() {
        return (i < data.length && j < data[i].length);
    }
}