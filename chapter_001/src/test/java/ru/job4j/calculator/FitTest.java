package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *FitTest.
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class FitTest {
    /**
     *Test manWeight.
     */@Test
    public void whenMenHeight180ThenWeight92() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, is(92D));
    }
    /**
     *Test womanWeight.
     */@Test
    public void whenWomenHeight170ThenWeight79() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, is(69D));
    }
}
