package ru.job4j.list;

public class SimpleStack<T> {
    private ContainerOnList<T> list = new ContainerOnList<>();

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.add(value);
    }
}