package ru.job4j.tree;

import java.util.*;
import java.util.Optional;

public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    public Node<E> root;
    private int modCount = 0;

    public MyTree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {

                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     */
    @Override
    public boolean add(E parent, E child) {
        Node<E> childIn = findBy(child).orElse(null);
        if (childIn != null) {
            System.out.println("Такой элемент уже есть.");
            return false;
        }

        if (!findBy(parent).isPresent()) {
            System.out.println("Такого родителя нет.");
            return false;
        }
        Node<E> parentIn = findBy(parent).get();
        Node<E> children = new Node<>(child);
        parentIn.children.add(children);
        modCount++;
        return true;
    }


    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Queue<Node<E>> nodeQueue = new LinkedList<>(Arrays.asList(root));
            private int modIter = modCount;

            public boolean hasNext() {
                if (modIter != modCount) {
                    throw new ConcurrentModificationException("Размер дерева был увеличен.");
                }
                return !nodeQueue.isEmpty();
            }


            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> res = this.nodeQueue.poll();
                nodeQueue.addAll(res.leaves());
                return res.value;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public boolean isBinary() {
        boolean rst = true;
        Queue<Node<E>> isTreeBinary = new LinkedList<>();
        isTreeBinary.offer(root);
        while (!isTreeBinary.isEmpty()) {
            Node<E> element = isTreeBinary.poll();
            int count = 0;
            for (Node<E> child : element.leaves()) {
                isTreeBinary.offer(child);
                count++;
            }
            if (count > 2) {
                rst = false;
                break;
            }
        }
        return rst;
    }
}