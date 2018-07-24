package ru.job4j.sorting;

import java.util.*;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftWorld = left.toCharArray();
        char[] rightWorld = right.toCharArray();

        int length1 = leftWorld.length;
        int length2 = rightWorld.length;
        int rst = 0;

        if (length1 < length2) {
            for (int i = 0; i < length1; i++) {
                if (leftWorld[i] != rightWorld[i]) {
                    rst = Character.compare(leftWorld[i], rightWorld[i]);
                    break;
                }
            }
            if (rst == 0) {
                rst = length1 - length2;
            }
        } else if (length2 < length1) {
            for (int i = 0; i < length2; i++) {
                if (leftWorld[i] != rightWorld[i]) {
                    rst = Character.compare(leftWorld[i], rightWorld[i]);
                    break;
                }
            }
            if (rst == 0) {
                rst = length1 - length2;
            }
        } else if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                if (leftWorld[i] != rightWorld[i]) {
                    rst = Character.compare(leftWorld[i], rightWorld[i]);
                    break;
                }
            }
        }
        return rst;
    }
}


