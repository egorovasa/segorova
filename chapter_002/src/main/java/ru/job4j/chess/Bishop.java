package ru.job4j.chess;
/**
 * @author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 * @version $Id$
 *
 * @since 0.1
 */
public class Bishop implements Figure {
    private final Cell position;

    public Bishop(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.y - source.y == dest.x - source.x) {
            if (source.y == dest.y + (dest.y - source.y) && source.x == dest.x + (dest.y - source.y)) {
            steps = new Cell[] {
                    dest };
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}