package ru.job4j.analyze;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    Analyze container = new Analyze();
    List<User> previousContainer = new LinkedList<>();
    List<User> currentContainer = new LinkedList<>();

    @Before
    public void addElementsInOldContainer() {
        previousContainer.add(new User(1, "Svetlana"));
        previousContainer.add(new User(2, "Marina"));
        previousContainer.add(new User(3, "Alice"));
        previousContainer.add(new User(4, "Vladimir"));
    }

    @Test
    public void whenBothContainersAreTheSame() {
        currentContainer.add(new User(1, "Svetlana"));
        currentContainer.add(new User(2, "Marina"));
        currentContainer.add(new User(3, "Alice"));
        currentContainer.add(new User(4, "Vladimir"));
        HashMap rst = container.collectionDifference(previousContainer, currentContainer);
        assertThat(rst.get("Количество измененных пользователей: "), is(0));
        assertThat(rst.get("Количество удалённых пользователей: "), is(0));
        assertThat(rst.get("Количество добавленных пользователей: "), is(0));
    }

    @Test
    public void whenThereIsADifferenceBetweenTwoCollections() {
        currentContainer.add(new User(1, "Svetlana"));
        currentContainer.add(new User(2, "Nadejda"));
        currentContainer.add(new User(3, "Alice"));
        currentContainer.add(new User(5, "Dmitry"));
        currentContainer.add(new User(6, "Leonid"));
        HashMap rst = container.collectionDifference(previousContainer, currentContainer);
        assertThat(rst.get("Количество измененных пользователей: "), is(1));
        assertThat(rst.get("Количество удалённых пользователей: "), is(1));
        assertThat(rst.get("Количество добавленных пользователей: "), is(2));
    }
}