package ru.job4j.iterator;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            List<Iterator<Iterator<Integer>>> iteratorList = new ArrayList<>();
                Collections.addAll(iteratorList,it);
            int index = 0;

            @Override
            public boolean hasNext() {
                return (iteratorList.get(index).hasNext()) || (index + 1 < iteratorList.size());
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (iteratorList.get(index).hasNext()) {
                    return iteratorList.get(index).next();
                } else {
                    return iteratorList.get(++index).next();
                }
            }
        };
    }
}