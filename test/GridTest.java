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
        grid.put(new Cell(true), 4,5);
        assertEquals(grid.getNumberOfNeighbors(5,5), 1);
        grid.put(new Cell(true), 5,4);
        assertEquals(grid.getNumberOfNeighbors(5,5), 2);
        grid.put(new Cell(true), 6,5);
        assertEquals(grid.getNumberOfNeighbors(5,5), 3);
        grid.put(new Cell(true), 5,6);
        assertEquals(grid.getNumberOfNeighbors(5,5), 4);
    }

    @Test
    public void testZoom() {
        Grid grid = new Grid(10,10);
        assertEquals(grid.getRowNumber(), 10);
        grid.zoom(1);
        // if you zoom by 1, you get 2 extra rows
        assertEquals(grid.getRowNumber(), 12);
        assertEquals(grid.getColNumber(), 12);
        grid.zoom(2);
        assertEquals(grid.getRowNumber(), 16);
        assertEquals(grid.getColNumber(), 16);
    }
}