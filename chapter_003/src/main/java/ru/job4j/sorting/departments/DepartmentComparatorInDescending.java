package ru.job4j.sorting.departments;

import java.util.Comparator;

public class DepartmentComparatorInDescending implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rst = 0;
        String[] pos1 = o1.split("//");
        String[] pos2 = o2.split("//");

        int len = pos1.length < pos2.length ? pos1.length : pos2.length;

        for (int i = 0; i < len; i++) {
            rst = pos2[i].compareTo(pos1[i]);
            if (rst != 0) {
                break;
            }
        }
        if (rst == 0) {
            rst = Integer.compare(pos2.length, pos1.length);
        }
        return rst;
    }
}