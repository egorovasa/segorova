package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CycleListTest<T> {

    @Test
    public void WhenListHasCycleThenTrue() {
        CycleList.Node one = new CycleList.Node(1);
        CycleList.Node two = new CycleList.Node(2);
        CycleList.Node three = new CycleList.Node(3);
        CycleList.Node four = new CycleList.Node(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = one;

        assertThat(CycleList.Node.hasCycle(one), is(true));
    }
}