package ru.job4j.CoffeeMachine;

class CoffeeMachine {

    int[] changes(int value, int price) {
        int change = value > price ? value - price : 0;
        int[] values = {10, 5, 2, 1};

        int numOfTen = change / 10;
        int numOfFive = (change - numOfTen * 10) / 5;
        int numOfTwo = (change - numOfTen * 10 - numOfFive * 5) / 2;
        int numOfOne = (change - numOfTen * 10 - numOfFive * 5 - numOfTwo * 2);
        int length = numOfTen + numOfFive + numOfTwo + numOfOne;

        int[] result = new int[length];
        int j = 0;
            for (int i = 0; i < values.length; i++) {
                while (change >= values[i]) {
                    change = change - values[i];
                    result[j] = values[i];
                    j++;
                }
            }
        return result;
    }
}