package test;

import src.main.java.Cell;
import src.main.java.Grid;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class GridTest {

    @Test
    public void testNeighboursNumber() {
        Grid grid = new Grid(10, 10);
        int neighborsOnTheCorner = grid.getNumberOfNeighbors(0,0);
        // there can be at most 3 neighbors of a corner cell
        assertTrue(neighborsOnTheCorner <= 3);
    }

    @Test
    public void testSpecificNeighbours() {
        Grid grid = new Grid(10,10);
        grid.killAllCells();
        grid.put(new Cell(true), 5,5);
        assertEquals(grid.getNumberOfNeighbors(5,5), 0);
        assertEquals(grid.getNumberOfNeighbors(4,5), 1);

    }
}