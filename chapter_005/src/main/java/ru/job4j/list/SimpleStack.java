package ru.job4j.list;

public class SimpleStack<T> {
    private ContainerOnList<T> list = new ContainerOnList<>();

    public void push(T value) {
        list.add(value);
    }

    public T poll() {
        return list.delete();
    }
}