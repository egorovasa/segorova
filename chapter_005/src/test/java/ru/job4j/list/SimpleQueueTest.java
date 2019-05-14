package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @Test
    public void whenPush456ThenPop654() {
        queue = new SimpleQueue<>();
        queue.push(4);
        queue.push(5);
        queue.push(6);
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));
        assertThat(queue.poll(), is(6));
    }
}
