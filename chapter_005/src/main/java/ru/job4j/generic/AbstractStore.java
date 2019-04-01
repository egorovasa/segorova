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
        boolean answer = false;
        for (int i = 0; i < count; i++) {
            if (this.data.get(i).getId().equals(id)) {
                this.data.set(i, model);
                answer = true;
                break;
            }
        }
        return answer;
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