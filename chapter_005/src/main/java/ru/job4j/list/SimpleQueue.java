package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> queue = new SimpleStack<>();
    private SimpleStack<T> anotherQueue = new SimpleStack<>();
    private int counter = 0;

    public void push(T value) {
        queue.push(value);
        this.counter++;
    }

    public T poll() {
        this.reverse();
        return this.anotherQueue.poll();
    }

    public void reverse() {
        for (int i = 0; i < this.counter; i++) {
            this.anotherQueue.push(this.queue.poll());
        }
        this.counter = 0;
    }
}