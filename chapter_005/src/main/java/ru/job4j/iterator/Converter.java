package ru.job4j.iterator;

import java.util.*;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            Iterator<Integer> current = it.next();

            @Override
            public boolean hasNext() {
                while (current == null || !current.hasNext()) {
                    if (!it.hasNext()) return false;
                    current = it.next();
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }
}
