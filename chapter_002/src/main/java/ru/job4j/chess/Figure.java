package ru.job4j.chess;
/**
 * @author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 * @version $Id$
 *
 * @since 0.1
 */
public interface Figure {
    /**
     * Возвращает текущую клетку, которую занимает фигура.
     */
    Cell position();
    /**
     * Метод, который проверяет, что данная фигура может так двигаться.
     *
     * @param source Источник, откуда мы идём.
     *
     * @param dest Destination, куда мы хотим пойти.
     *
     * @return если мы можем идти по нужному пути, возвращает массив ячеек, которые нужно пройти.
     *
     */
    Cell[] way(Cell source, Cell dest);
    /**
     * Создаёт новую фигуру с координатой dest.
     * @param dest итоговое назначение.
     * @return фигуру с новой позицией.
     */

    Figure copy(Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }
}

