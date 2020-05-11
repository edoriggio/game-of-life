package src.test.java;

import org.junit.Test;
import src.main.java.Cell;
import src.main.java.State;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void testGetState() {
        Cell cell = new Cell(State.ALIVE);
        assertEquals(State.ALIVE, cell.getState());
    }

    @Test
    public void testSetState() {
        Cell cell = new Cell(State.DEAD);
        assertEquals(State.DEAD, cell.getState());
        cell.setState(State.ALIVE);
        assertEquals(State.ALIVE, cell.getState());
    }
    
}