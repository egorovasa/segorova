package ru.job4j.function;

import java.util.*;

public class Function {

    List<Double> diapason(double start, double end, double step, MyFunc func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i <= end; i += step) {
            result.add(func.calculate(i));
        }
        return result;
    }
}