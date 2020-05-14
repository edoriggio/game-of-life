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

    /**
     * Set up the first grid to be empty ( only DEAD cells ).
     * Initialize BorderRule for the Neighbouring rule
     * Initialize NeighbouringRule for the class Compute
     */
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

    /**
     * Clean up everything in grid1, so that for the next method, grid1 only has DEAD cells.
     */
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
    // _________________ TESTING STABLE SHAPES ______________________
    /*
        Testing that a stable shape stays like that:
        From Wikipedia "Still lifes of the Game of Life" : "Block"
     */
    @Test
    public void testStableGridBlock() {

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

    /*
        Testing that a stable shape stays like that:
        From Wikipedia "Still lifes of the Game of Life" : "Boat"
     */
    @Test
    public void testStableGridBoat() {
        grid1.getCell(4, 4).setState(State.ALIVE);
        grid1.getCell(4, 3).setState(State.ALIVE);
        grid1.getCell(5, 3).setState(State.ALIVE);
        grid1.getCell(5, 5).setState(State.ALIVE);
        grid1.getCell(6, 4).setState(State.ALIVE);
        grid1.printGrid();

        Compute.computeNextGrid(moore, grid1, grid2);
        //grid2.printGrid();
        assertTrue(grid2.getCell(4, 4).getState() == State.ALIVE);
        assertTrue(grid2.getCell(4, 3).getState() == State.ALIVE);
        assertTrue(grid2.getCell(5, 3).getState() == State.ALIVE);
        assertTrue(grid2.getCell(5, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(6, 4).getState() == State.ALIVE);
        // possibly add loop here to check the rest is dead as in the test above...
    }

    // _________________ TESTING OSCILLATOR SHAPES ______________________

    @Test
    public void testBlinkerOscillator() {
        grid1.getCell(4,4).setState(State.ALIVE);
        grid1.getCell(4,5).setState(State.ALIVE);
        grid1.getCell(4,6).setState(State.ALIVE);

        //                  X
        //  X X X    ->     X
        //                  X

        Compute.computeNextGrid(moore, grid1, grid2);
        assertTrue(grid2.getCell(3, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(4, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(5, 5).getState() == State.ALIVE);

        //  X
        //  X       ->     X X X
        //  X

        Compute.computeNextGrid(moore, grid2, grid1);
        assertTrue(grid1.getCell(4, 4).getState() == State.ALIVE);
        assertTrue(grid1.getCell(4, 5).getState() == State.ALIVE);
        assertTrue(grid1.getCell(4, 6).getState() == State.ALIVE);
    }

    @Test
    public void testToadOscillator() {
        grid1.getCell(3,3).setState(State.ALIVE);
        grid1.getCell(3,4).setState(State.ALIVE);
        grid1.getCell(3,5).setState(State.ALIVE);
        grid1.getCell(4,2).setState(State.ALIVE);
        grid1.getCell(4,3).setState(State.ALIVE);
        grid1.getCell(4,4).setState(State.ALIVE);

        //                     X
        //    X X X     ->  X   X
        //  X X X           X   X
        //                   X
        Compute.computeNextGrid(moore, grid1, grid2);

        assertTrue(grid2.getCell(5, 3).getState() == State.ALIVE);
        assertTrue(grid2.getCell(4, 2).getState() == State.ALIVE);
        assertTrue(grid2.getCell(3, 2).getState() == State.ALIVE);
        assertTrue(grid2.getCell(4, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(3, 5).getState() == State.ALIVE);
        assertTrue(grid2.getCell(2, 4).getState() == State.ALIVE);

        //     X
        //  X   X     ->     X X X
        //  X   X          X X X
        //   X

        Compute.computeNextGrid(moore, grid2, grid1);
        assertTrue(grid1.getCell(3, 3).getState() == State.ALIVE);
        assertTrue(grid1.getCell(3, 4).getState() == State.ALIVE);
        assertTrue(grid1.getCell(3, 5).getState() == State.ALIVE);
        assertTrue(grid1.getCell(4, 2).getState() == State.ALIVE);
        assertTrue(grid1.getCell(4, 3).getState() == State.ALIVE);
        assertTrue(grid1.getCell(4, 4).getState() == State.ALIVE);

    }

}
