package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFor2DArray implements Iterator {

    private int point = 0;
    private int[][] data;

    public IteratorFor2DArray(int[][] data) {
        this.data = data;
    }

    @Override
    public Integer next() {
        int nextPoint = 0;
        for (int[] innerArray : data) {
            for (int cell : innerArray) {
                if (nextPoint++ == point) {
                    point++;
                    return cell;
                }
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for (int[] row : data) {
            count += row.length;
        }
        return point != count;
    }
}