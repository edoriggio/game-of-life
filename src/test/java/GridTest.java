package src.test.java;

import org.junit.Test;
import src.main.java.Grid;

import static org.junit.Assert.*;

/**
 * Test class for the Grid class.
 *
 * @author Edoardo Riggio
 */
public class GridTest {

    @Test
    public void testGetColumns() {
        Grid grid = new Grid(1,2);
        assertEquals(2, grid.getColumns());
    }

    @Test
    public void testGetRows() {
        Grid grid = new Grid(1,2);
        assertEquals(1, grid.getRows());
    }

    @Test
    public void testPrintGrid() {
        Grid grid = new Grid(1,2);
        grid.printGrid();
    }

    @Test
    public void testGetCell() {
        Grid grid = new Grid(5,5);
        grid.getCell(-1,-1);
        grid.getCell(2,2);
    }

}
