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

    public boolean poli(boolean[][] table) {
        boolean horizontalWinner = true;
        boolean verticalWinner = true;
        boolean leftDiagonalWinner = true;
        boolean rightDiagonalWinner = true;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                horizontalWinner = true;
                if ((table[i][j] != table[i][0])) {
                    horizontalWinner = false;
                    break;
                }
            }
            if (horizontalWinner) {
                break;
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                verticalWinner = true;
                if ((table[i][j] != table[0][i])) {
                    verticalWinner = false;
                    break;
                }
            }
            if (verticalWinner) {
                break;
            }
        }
        for (int j = 0; j < table.length; j++) {
            if ((table[j][j] != table[0][0])) {
                leftDiagonalWinner = false;
                break;
            }
        }
        for (int j = 0; j < table.length; j++) {
            if ((table[0][table.length - 1] != table[table.length - j - 1][j])) {
                rightDiagonalWinner = false;
                break;
            }
        }
        return horizontalWinner || verticalWinner || rightDiagonalWinner || leftDiagonalWinner;
    }
}