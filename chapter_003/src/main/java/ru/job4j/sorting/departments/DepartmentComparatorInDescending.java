package ru.job4j.sorting.departments;

import java.util.*;

public class DepartmentComparatorInDescending implements Comparator<String> {

    public TreeSet<String> split(String o1) {
        TreeSet<String> result = new TreeSet<>();
        int number = 0;
        result.add(o1);
        for (char c : o1.toCharArray()) {
            if (c == '\\') {
                result.add(o1.substring(0, number));
            }
            number++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1"};
        TreeSet<String> dep1 = new TreeSet<>();
        TreeSet<String> dep2 = new TreeSet<>();
        for (String s : departments) {
            if (s.substring(0, 2).equals("K1")) {
                dep1.add(s);
            } else {
                dep2.add(s);
            }
        }
        List<String> result = new ArrayList<>();
        result.addAll(dep2);
        result.addAll(dep1);
        System.out.println(result);
    }

    @Override
    public int compare(String o1, String o2) {
        int rst = 0;
        DepartmentComparatorInDescending dep = new DepartmentComparatorInDescending();

        TreeSet<String> set1 = dep.split(o1);
        TreeSet<String> set2 = dep.split(o2);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.addAll(set1.descendingSet());
        list2.addAll(set2.descendingSet());

        int len = list1.size() < list2.size() ? list1.size() : list2.size();

        for (int i = 0; i < len; i++) {
            rst = list2.get(i).compareTo(list1.get(i));
            if (rst > 0) {
                rst = Integer.compare(list1.size(), list2.size());
            }
            /*if (rst < 0) {
                rst = list1.get(i).compareTo(list2.get(i));
            }*/
/*         if (rst != 0) {
                break;
            }*/
        }
        return rst;
    }
}