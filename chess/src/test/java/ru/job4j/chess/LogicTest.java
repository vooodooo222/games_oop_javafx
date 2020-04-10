package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void moveSuccess() {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        boolean result = logic.move(bishopBlack.position(), Cell.C3);
        assertThat(result, is(true));
    }

    @Test
    public void sourceNotFindForMove() {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.A1);
        boolean result = logic.move(bishopBlack.position(), Cell.C3);
        assertThat(result, is(false));
    }

    @Test
    public void isWayFree() {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        Cell[] steps = new Cell[]{ Cell.B2, Cell.C3 };
        boolean result = logic.isWayFree(steps);
        assertThat(result, is(true));
    }

    @Test
    public void isWayNotFree() {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Figure pawnBlack = new PawnBlack(Cell.B2);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        Cell[] steps = new Cell[]{ Cell.B2, Cell.C3 };
        boolean result = logic.isWayFree(steps);
        assertThat(result, is(false));
    }
}