package ru.job4j.list;

public class CycleList<T> {
    private Node<T> first;

    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }

        public static boolean hasCycle(Node first) {
            Node slow = first;
            Node fast = first;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}