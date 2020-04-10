package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position(), is(Cell.A1));
    }

    @Test
    public void copyTest() {
        Figure bishopBlack1 = new BishopBlack(Cell.A1);
        Figure bishopBlack2 = bishopBlack1.copy(Cell.A2);
        assertThat(bishopBlack2.position(), is(Cell.A2));
    }

    @Test (expected = IllegalStateException.class)
    public void wayTest() {
        Figure bishopBlack1 = new BishopBlack(Cell.C1);
        Cell[] wayCells = bishopBlack1.way(Cell.C1, Cell.G5);
        Cell[] expectedWayCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(wayCells, is(expectedWayCells));
        Figure bishopBlack2 = new BishopBlack(Cell.C1);
        bishopBlack2.way(Cell.C1, Cell.C5);
    }

    @Test
    public void isDiagonalTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        boolean firstStepIsDiagonal = bishopBlack.isDiagonal(Cell.D4, Cell.F6);
        boolean secondStepIsDiagonal = bishopBlack.isDiagonal(Cell.D4, Cell.B6);
        boolean thirdStepIsDiagonal = bishopBlack.isDiagonal(Cell.D4, Cell.B2);
        boolean forthStepIsDiagonal = bishopBlack.isDiagonal(Cell.D4, Cell.F2);
        boolean lastStepIsDiagonal = bishopBlack.isDiagonal(Cell.D4, Cell.D6);
        assertThat(firstStepIsDiagonal, is(true));
        assertThat(secondStepIsDiagonal, is(true));
        assertThat(thirdStepIsDiagonal, is(true));
        assertThat(forthStepIsDiagonal, is(true));
        assertThat(lastStepIsDiagonal, is(false));
    }
}