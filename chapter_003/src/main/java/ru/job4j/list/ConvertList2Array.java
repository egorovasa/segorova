package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**ConvertList2Array.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class ConvertList2Array {

    int[][] toArray(List<Integer> list, int rows) {

        int cells;
        if (list.size() % rows != 0) {
            cells = list.size() / rows + 1;
        } else {
            cells = list.size() / rows;
        }

        int[][] array = new int[rows][cells];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (k < list.size()) {
                    array[i][j] = list.get(k);
                    k++;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j : list.get(i)) {
                result.add(j);
            }
        }
        return result;
    }
}