package ru.job4j.array;
/**Matrix.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Matrix {
    int[][] multiple(int size) {
        int i;
        int j;
        int[][] rst = new int[size][size];
        for (i = 0; i <= size - 1; i++) {
            for (j = 0; j <= size - 1; j++) {
                rst[i][j] = (i + 1) * (j + 1);
            }
        }
        return rst;
    }
}