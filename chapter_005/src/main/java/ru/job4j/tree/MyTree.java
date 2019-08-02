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
        List<Node<E>> listChild = parentIn.children;
        Node<E> children = new Node<>(child);
        parentIn.children.add(children);
        modCount++;
        return true;
    }


    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private ArrayList<Node<E>> arrayList = new ArrayList<>();

            {
                arrayList.add(root);
            }

            private int index = 0;
            private int modIter = modCount;

            @Override
            public boolean hasNext() {
                boolean rst = false;
                if (modIter != modCount) {
                    throw new ConcurrentModificationException("Размер дерева был увеличен.");
                }
                if (index == arrayList.size()) {
                    ArrayList<Node<E>> array = new ArrayList<>();
                    for (Node<E> node : arrayList) {
                        array.addAll(node.children);
                    }
                    arrayList = array;
                    index = 0;
                }
                if (index <= arrayList.size()) {
                    rst = true;
                }
                return rst;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arrayList.get(index++).value;
            }
        };
    }
}