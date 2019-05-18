package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class SimpleSetTest {
    private SimpleSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
    }

    @Test
    public void WhenAddDuplicateThenItDoesNotAdd() {
        assertThat(set.get(2), is(3));
    }
}