package ru.job4j.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionTest {
    @Test
    public void whenLinearFunctionThenValueList() {
        Function func1 = new Function();
        double start = 10.0;
        double end = 20.0;
        double step = 2.0;
        MyFunc linearFunction = (x) -> x;
        assertThat((func1.diapason(start, end, step, linearFunction).get(1)), is(12.0));
    }

    @Test
    public void whenSquaredFunctionThenValueList() {
        Function func1 = new Function();
        double start = 10.0;
        double end = 20.0;
        double step = 2.0;
        MyFunc squaredFunction = (x) -> Math.pow(x, 2.0);
        assertThat((func1.diapason(start, end, step, squaredFunction).get(1)), is(144.0));
    }

    @Test
    public void whenLogarithmicFunctionThenValueList() {
        Function func1 = new Function();
        double start = 10.0;
        double end = 20.0;
        double step = 2.0;
        MyFunc logarithmicFunction = (x) -> Math.log10(x);
        assertThat((func1.diapason(start, end, step, logarithmicFunction).get(0)), is(1.0));
    }
}