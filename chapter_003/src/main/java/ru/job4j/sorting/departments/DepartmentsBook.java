package ru.job4j.sorting.departments;

import java.util.*;

public class DepartmentsBook {

    public String[] sortDepartmentsInAscending(String[] array) {
        Arrays.sort(array, new DepartmentComparatorInAscending());
        return array;
    }

    public String[] sortDepartmentsInDescending(String[] array) {
        Arrays.sort(array, new DepartmentComparatorInDescending());
        return array;
    }
}