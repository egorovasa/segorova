package ru.job4j.generic;

import java.util.*;

public class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> data;
    private int count;

    public AbstractStore(SimpleArray<T> data) {
        this.data = data;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void add(T model) {
        data.add(model);
        count++;
    }

    @Override
    public boolean replace(String id, T model) {
        for (T value : data) {
            if (value.getId().equals(id)) {
                value = model;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = 0;
        for (T value : data) {
            if (value.getId().equals(id)) {
                data.delete(index);
                count--;
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T value : data) {
            if (value.getId().equals(id)) {
                result = value;
                break;
            }
        }
        return result;
    }
}