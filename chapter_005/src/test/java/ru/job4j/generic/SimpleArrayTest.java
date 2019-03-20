package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenAddElementThenItBecomesTrue() {
        SimpleArray<Integer> array = new SimpleArray<>(2);
        array.add(1);
        Integer result = array.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenDeleteElementThenWeReallyDeleteIt() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.delete(0);
        Integer result = array.get(0);
        assertThat(result, is(2));
    }

    @Test
    public void whenMassiveThenWorkingNext() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(3);
        array.add(5);
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }
}