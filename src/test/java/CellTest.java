package src.test.java;

import org.junit.Test;
import src.main.java.Cell;
import src.main.java.State;

import static org.junit.Assert.*;

/**
 * Test class for the Cell class.
 *
 * @author Edoardo Riggio
 */

public class CellTest {

    @Test
    public void testGetState() {
        Cell cell = new Cell(State.ALIVE);
        assertEquals("alive", cell.getState().getName());
        Cell cell2 = new Cell(State.DEAD);
        assertEquals("dead", cell2.getState().getName());
    }

    @Test
    public void testSetState() {
        Cell cell = new Cell(State.DEAD);
        assertEquals("dead", cell.getState().getName());
        cell.setState(State.ALIVE);
        assertEquals("alive", cell.getState().getName());
    }

}