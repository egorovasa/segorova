package ru.job4j.sorting;

import java.util.*;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        ArrayList<Character> leftList = new ArrayList<>();
        ArrayList<Character> rightList = new ArrayList<>();
        for (char c : left.toCharArray()) {
            leftList.add(c);
        }
        for (char c : right.toCharArray()) {
            rightList.add(c);
        }
        int length1 = leftList.size();
        int length2 = rightList.size();

        int rst = 0;

        if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                rst += Character.compare(leftList.get(i), rightList.get(i));
            }
        } else if (length1 > length2) {
            for (int j = 0; j < length1 - length2; j++) {
                for (int i = 0; i < length2; i++) {
                    if (leftList.get(i + j) != rightList.get(i)) {
                        rst = leftList.get(i + j) - rightList.get(i);
                        break;
                    }
                }
            }
            if (rst == 0) {
                rst = length1 - length2;
            }
        } else if (length2 > length1) {
            for (int j = 0; j < length2 - length1; j++) {
                for (int i = 0; i < length1; i++) {
                    if (rightList.get(i + j) != leftList.get(i)) {
                        rst = leftList.get(i) - rightList.get(i + j);
                        break;
                    }
                }
            }
            if (rst == 0) {
                rst = length1 - length2;
            }
        }
        return rst;
    }
}

