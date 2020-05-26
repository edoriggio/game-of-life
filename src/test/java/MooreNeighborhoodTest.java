package src.test.java;

import org.junit.Test;
import src.main.java.*;

import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;

// Note that this Neighborhood Rules gives the positions in this order:
// North, South, East, West, North-West, North-east, South-West, South-east

/**
 * Test Class for the MooreNeighborHood class.
 *
 * @author Michele Cattaneo
 */
public class MooreNeighborhoodTest {

    @Test
    public void testCornerPosition() {
        BorderRule borderRule = new TorusRule();
        Neighborhood moore = new MooreNeighborhood(borderRule);
        Grid grid = new Grid(10,20);
        // get all neighbors of the position (0,0) with a more law and a torus law ( border )
        LinkedList<int[]> neighbors = moore.getNeighbors(grid, 0, 0);

        // North
        assertArrayEquals(neighbors.get(0), new int[]{9, 0});
        // South
        assertArrayEquals(neighbors.get(1), new int[]{1, 0});
        // East
        assertArrayEquals(neighbors.get(2), new int[]{0, 1});
        // West
        assertArrayEquals(neighbors.get(3), new int[]{0, 19});
        // North-West
        assertArrayEquals(neighbors.get(4), new int[]{9, 19});
        // North-east
        assertArrayEquals(neighbors.get(5), new int[]{9, 1});
        // South-west
        assertArrayEquals(neighbors.get(6), new int[]{1, 19});
        // South-east
        assertArrayEquals(neighbors.get(7), new int[]{1, 1});
    }

    @Test
    public void testCentralPosition() {
        BorderRule borderRule = new TorusRule();
        Neighborhood moore = new MooreNeighborhood(borderRule);
        Grid grid = new Grid(10,10);
        LinkedList<int[]> neighbors = moore.getNeighbors(grid, 5,5);

        // North
        assertArrayEquals(neighbors.get(0), new int[]{4, 5});
        // South
        assertArrayEquals(neighbors.get(1), new int[]{6, 5});
        // East
        assertArrayEquals(neighbors.get(2), new int[]{5, 6});
        // West
        assertArrayEquals(neighbors.get(3), new int[]{5, 4});
        // North-West
        assertArrayEquals(neighbors.get(4), new int[]{4, 4});
        // North-east
        assertArrayEquals(neighbors.get(5), new int[]{4, 6});
        // South-west
        assertArrayEquals(neighbors.get(6), new int[]{6, 4});
        // South-east
        assertArrayEquals(neighbors.get(7), new int[]{6, 6});
    }

    @Test
    public void testPrintNeighbors() {
        BorderRule borderRule = new TorusRule();
        MooreNeighborhood moore = new MooreNeighborhood(borderRule);
        Grid grid = new Grid(10,10);

        moore.printNeighbors(grid,5,5);
    }
}
