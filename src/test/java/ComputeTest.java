package src.test.java;

import org.junit.Test;
import src.main.java.*;

import static org.junit.Assert.*;

public class ComputeTest {

    @Test
    public void testEmptyGrid() {
        Grid grid1 = new Grid(10,10);
        Grid grid2 = new Grid(10,10);
        BorderRule torus = new TorusRule();
        Neighborhood moore = new MooreNeighborhood(torus);

        // Set all Cells to be dead in grid 1, so that whatever the default constructor
        // of grid will do, we are sure they are all dead
        for (int i = 0; i < grid1.getRows(); i++ ) {
            for (int j = 0; j < grid1.getColumns(); j++ ) {
                grid1.getCell(i, j).setState(State.DEAD);
            }
        }

        Compute.computeNextGrid(moore, grid1, grid2);

    }
}
