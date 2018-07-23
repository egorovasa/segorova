package ru.job4j.sorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListOfUsersThenSortingUserByAgeTreeSet() {
        assertThat(
                new SortUserByAge().compare(
                        new User("Svetlana", 27),
                        new User("Petr", 26)
                ), is(1));
    }

    @Test
    public void whenListOfUsersThenSortUserByNameLengthTreeSet() {
        assertThat(
                new SortUserByNameLength().compare(
                        new User("Svetlana", 27),
                        new User("Petr", 26)
                ), is(4));
    }

    @Test
    public void whenListOfUsersThenSortingUserByAllFieldsTreeSet() {
        Comparator<User> pcomp = new SortUserByAlphabetName().thenComparing(new SortUserByAge());
        TreeSet<User> users = new TreeSet(pcomp);
        users.add(new User("Svetlana", 27));
        users.add(new User("Petr", 26));
        TreeSet<User> expected = new TreeSet<>();
        expected.add(new User("Petr", 26));
        expected.add(new User("Svetlana", 27));
        assertThat(users, is(expected));
    }
}