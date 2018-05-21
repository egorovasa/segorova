/*package ru.job4j.Chess;

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
    public Cell[] way(Cell sourse, Cell dest) {
        Cell[] steps = new Cell[0];
        if (sourse.y == dest.y +1 && sourse.x == dest.x +1) {
            steps = new Cell[] { dest };
        }
        return steps;
    }
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
*/