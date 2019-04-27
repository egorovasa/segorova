package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ContainerOnList<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modCount;

    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int expectedModCount = modCount;
            Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                Node<E> result = currentNode;
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                currentNode = currentNode.next;
                return result.date;
            }
        };
    }

    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}