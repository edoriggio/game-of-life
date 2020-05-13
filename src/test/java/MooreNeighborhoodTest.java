package src.test.java;

import org.junit.Test;
import src.main.java.*;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

// Note that this Neighborhood Rules gives the positions in this order:
// North, South, East, West, North-West, North-east, South-West, South-east
public class MooreNeighborhoodTest {

    @Test
    public void testCornerPosition() {
        BorderRule borderRule = new TorusRule();
        Neighborhood moore = new MooreNeighborhood(borderRule);
        Grid grid = new Grid(10,20);
        // get all neighbors of the position (0,0) with a more law and a torus law ( border )
        LinkedList<int[]> neighbors = moore.getNeighbors(grid, 0, 0);

        // North
        assertTrue(Arrays.equals(neighbors.get(0), new int[]{9, 0}));
        // South
        assertTrue(Arrays.equals(neighbors.get(1), new int[]{1, 0}));
        // East
        assertTrue(Arrays.equals(neighbors.get(2), new int[]{0, 1}));
        // West
        assertTrue(Arrays.equals(neighbors.get(3), new int[]{0, 19}));
        // North-West
        assertTrue(Arrays.equals(neighbors.get(4), new int[]{9, 19}));
        // North-east
        assertTrue(Arrays.equals(neighbors.get(5), new int[]{9, 1}));
        // South-west
        assertTrue(Arrays.equals(neighbors.get(6), new int[]{1, 19}));
        // South-east
        assertTrue(Arrays.equals(neighbors.get(7), new int[]{1, 1}));
    }

    @Test
    public void testCentralPosition() {
        BorderRule borderRule = new TorusRule();
        Neighborhood moore = new MooreNeighborhood(borderRule);
        Grid grid = new Grid(10,10);
        LinkedList<int[]> neighbors = moore.getNeighbors(grid, 5,5);

        // North
        assertTrue(Arrays.equals(neighbors.get(0), new int[]{4, 5}));
        // South
        assertTrue(Arrays.equals(neighbors.get(1), new int[]{6, 5}));
        // East
        assertTrue(Arrays.equals(neighbors.get(2), new int[]{5, 6}));
        // West
        assertTrue(Arrays.equals(neighbors.get(3), new int[]{5, 4}));
        // North-West
        assertTrue(Arrays.equals(neighbors.get(4), new int[]{4, 4}));
        // North-east
        assertTrue(Arrays.equals(neighbors.get(5), new int[]{4, 6}));
        // South-west
        assertTrue(Arrays.equals(neighbors.get(6), new int[]{6, 4}));
        // South-east
        assertTrue(Arrays.equals(neighbors.get(7), new int[]{6, 6}));
    }
}
