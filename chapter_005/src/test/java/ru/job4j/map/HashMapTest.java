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
        myHashMap.insert(0, "Test 0");
        myHashMap.insert(1, "Test 1");
    }

    @Test
    public void whenInsertElementThenSizeBecomesBigger() {
        myHashMap.insert(2, "Test 2");
        myHashMap.insert(3, "Test 3");
        assertThat(myHashMap.get(0), is("Test 0"));
        assertThat(myHashMap.get(1), is("Test 1"));
        assertThat(myHashMap.get(2), is("Test 2"));
        assertThat(myHashMap.get(3), is("Test 3"));
    }

    @Test
    public void whenDeleteAnElementThenSizeBecomesLess() {
        myHashMap.delete(1);
        assertThat(myHashMap.getSize(), is(1));
        assertThat(myHashMap.delete(0), is(true));
    }

    @Test
    public void whenIteratorThenFineEnumeration() {
        Iterator<String> it = myHashMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test 0"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test 1"));
        assertThat(it.hasNext(), is(false));
    }
}