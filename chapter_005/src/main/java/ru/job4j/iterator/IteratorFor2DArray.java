package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFor2DArray implements Iterator {

    private int size;
    private int i = 0;
    private int j = 0;
    private int[][] values = new int[i][j];
    private int position = 0;

    public IteratorFor2DArray(int[][] values) {
        this.values = values;
        this.size = countOfElements(values);
    }

    private int countOfElements(int[][] values) {
        int count = 0;
        for (int[] row : values) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public Integer next() {
        if (position >= size) {
            throw new NoSuchElementException();
        }
        int element = values[i][j];
        position++;
        j++;
        while (i < values.length && j >= values[i].length) {
            j = 0;
            i++;
        }
        return element;
    }
}