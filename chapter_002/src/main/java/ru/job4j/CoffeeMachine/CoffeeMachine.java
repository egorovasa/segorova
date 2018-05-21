package ru.job4j.CoffeeMachine;

public class CoffeeMachine {
    int[] changes(int value, int price) {

        int diff = value - price;
        int numOfTen = diff / 10;
        int numOfFive = (diff - numOfTen * 10) / 5;
        int numOfTwo = (diff - numOfTen * 10 - numOfFive * 5) / 2;
        int numOfOne = (diff - numOfTen * 10 - numOfFive * 5 - numOfTwo * 2);
        int length = numOfTen + numOfFive + numOfTwo + numOfOne;

        if (length == 0) {
            length++;
        }

        int[] result;
        result = new int[length];

        for (int i = 0; i < result.length; i++) {
            if (numOfTen > 0) {
                result[i] = 10;
                numOfTen--;
            } else if (numOfFive > 0) {
                result[i] = 5;
                numOfFive--;
            } else if (numOfTwo > 0) {
                result[i] = 2;
                numOfTwo--;
            } else if (numOfOne > 0) {
                result[i] = 1;
                numOfOne--;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}