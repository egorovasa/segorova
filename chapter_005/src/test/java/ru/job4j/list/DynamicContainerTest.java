package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicContainerTest {
    private DynamicContainer<Integer> container;

    @Before
    public void beforeTest() {
        container = new DynamicContainer<>(3);
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    public void whenAddElementsThenNewBiggerContainer() {
        container.getSpace();
        container.add(4);
        assertThat(container.get(3), is(4));
        assertThat(container.getSize(), is(6));
    }

    @Test
    public void iterator() {
        Iterator<Integer> it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}