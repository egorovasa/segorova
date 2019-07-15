package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean temp1 = data[0][0];
        boolean temp2 = data[0][data.length - 1];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if ((data[i][i] != temp1) || (data[i][data.length - i - 1] != temp2)) {
                    return false;
                }
            }
        }
        return true;
    }
}