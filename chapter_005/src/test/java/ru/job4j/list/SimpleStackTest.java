package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    private SimpleStack<Integer> list;
    @Test
    public void whenPush456ThenPop654() {
        list = new SimpleStack<>();
        list.push(4);
        list.push(5);
        list.push(6);
        assertThat(list.poll(), is(6));
        assertThat(list.poll(), is(5));
        assertThat(list.poll(), is(4));
    }
}