package ru.job4j.function;

import org.junit.Test;

import java.util.function.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyBiFunctionTest {
    @Test
    public void whenLinearFunctionThenValueList() {
        double start = 10.0;
        double end = 20.0;
        BiFunction<Double, Double, Double> linearFunction = (x, y) -> y * x;
        MyBiFunction func1 = new MyBiFunction();
        assertThat((func1.diapasonWithBiFunction(start, end, linearFunction).get(1)), is(22.0));
    }

    @Test
    public void whenSquaredFunctionThenValueList() {
        double start = 10.0;
        double end = 20.0;
        BiFunction<Double, Double, Double> squaredFunction = (x, y) -> y * Math.pow(x, 2.0);
        MyBiFunction func1 = new MyBiFunction();
        assertThat((func1.diapasonWithBiFunction(start, end, squaredFunction).get(1)), is(242.0));
    }

    @Test
    public void whenLogarithmicFunctionThenValueList() {
        MyBiFunction func1 = new MyBiFunction();
        double start = 10.0;
        double end = 20.0;
        BiFunction<Double, Double, Double> logarithmicFunction = (x, y) -> y * Math.log10(x);
        assertThat((func1.diapasonWithBiFunction(start, end, logarithmicFunction).get(0)), is(2.0));
    }
}