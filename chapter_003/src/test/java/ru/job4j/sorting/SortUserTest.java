package ru.job4j.sorting;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListOfUsersThenSortingUserTreeSet() {
        assertThat(
                new SortUser().compare(
                        new User("Svetlana", 27),
                        new User("Petr", 26)
                ), is(1));
    }

}