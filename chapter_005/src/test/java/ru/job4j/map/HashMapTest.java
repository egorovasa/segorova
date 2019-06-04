package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashMapTest {
    private HashMap<Integer, String> myHashMap;

    @Before
    public void beforeTest() {
        myHashMap = new HashMap<>(3);
        myHashMap.insert(1, "Test 1");
        myHashMap.insert(2, "Test 2");
    }

    @Test
    public void whenInsertElementThenSizeBecomesBigger() {
        myHashMap.insert(3, "Test 3");
        myHashMap.getSpace();
        myHashMap.insert(4, "Test 4");
        assertThat(myHashMap.get(3), is("Test 3"));
        assertThat(myHashMap.get(4), is("Test 4"));
    }

    @Test
    public void whenDeleteAnElementThenSizeBecomesLess() {
        myHashMap.delete(2);
        assertThat(myHashMap.getSize(), is(1));
        assertThat(myHashMap.delete(1), is(true));
    }

    @Test
    public void whenIteratorThenFineEnumeration() {
        Iterator<String> it = myHashMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test 1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test 2"));
        assertThat(it.hasNext(), is(false));
    }
}