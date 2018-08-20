package ru.job4j.sorting.departments;

import java.util.Comparator;

public class DepartmentComparatorInDescending implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rst = Integer.compare(o2.length(), o1.length());
        if (rst != 0) {
            rst = o2.compareTo(o1);
        }
        return rst;
    }
}