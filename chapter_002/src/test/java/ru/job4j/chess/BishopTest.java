package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**BishopTest.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 *
 * @version $Id$
 *
 * @since 0.1
 *
 */
public class BishopTest {
    /**
     * Test way.
     */
    @Test
    public void whenMoveBishopThenNewDest() {
        Cell source = Cell.A1;
        Cell dest = Cell.H7;
        Bishop bishop = new Bishop(source);
        assertThat(bishop.way(source, dest)[dest.y - source.y - 1], is(dest));
    }
}
