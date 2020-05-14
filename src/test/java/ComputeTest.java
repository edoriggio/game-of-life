package src.test.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.main.java.*;

import static org.junit.Assert.*;

public class ComputeTest {
    Grid grid1;
    Grid grid2;
    BorderRule torus;
    Neighborhood moore;

    @Before
    public void setUpEmptyGrids() {
        grid1 = new Grid(10, 10);
        grid2 = new Grid(10, 10);
        torus = new TorusRule();
        moore = new MooreNeighborhood(torus);

        for (int i = 0; i < grid1.getRows(); i++ ) {
            for (int j = 0; j < grid1.getColumns(); j++ ) {
                grid1.getCell(i, j).setState(State.DEAD);
            }
        }
        System.out.println("Set up test grids..");
    }

    @After
    public void cleanUp() {
        for (int i = 0; i < grid1.getRows(); i++ ) {
            for (int j = 0; j < grid1.getColumns(); j++ ) {
                grid1.getCell(i, j).setState(State.DEAD);
            }
        }
        System.out.println("Cleaned up grids..");
    }

    /*
        Testing that an empty (all DEAD ) grid stays empty
     */
    @Test
    public void testEmptyGrid() {
        Compute.computeNextGrid(moore, grid1, grid2);
        for (int i = 0; i < grid2.getRows(); i++ ) {
            for (int j = 0; j < grid2.getColumns(); j++ ) {
                assertTrue(grid2.getCell(i, j).getState() == State.DEAD);
            }
        }
        //grid2.printGrid();
    }
    /*
        Testing that a stable shape stays like that
     */
    @Test
    public void testStableGridBlock() {
        // From Wikipedia Still lifes of the Game of Life: "Block"
        grid1.getCell(5,5).setState(State.ALIVE);
        grid1.getCell(5,6).setState(State.ALIVE);
        grid1.getCell(6,5).setState(State.ALIVE);
        grid1.getCell(6,6).setState(State.ALIVE);


        Compute.computeNextGrid(moore, grid1, grid2);
        assertTrue(grid2.getCell(5, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(5, 6).getState() == State.ALIVE);
        assertTrue(grid2.getCell(6, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(6, 6).getState() == State.ALIVE);
        for (int i = 0; i < grid1.getRows(); i++ ) {
            for (int j = 0; j < grid1.getColumns(); j++ ) {
                if ( (i != 5 && j != 5) && (i != 5 && j != 6) && (i != 6 && j != 5) && (i != 6 && j != 6)) {
                    assertTrue(grid2.getCell(i, j).getState() == State.DEAD);
                }
            }
        }

    }
}
