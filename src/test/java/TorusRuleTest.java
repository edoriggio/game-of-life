package src.test.java;

import org.junit.Test;
import src.main.java.Grid;
import src.main.java.TorusRule;

import static org.junit.Assert.*;

/**
 * Test class for TorusRule class.
 *
 * @author Michele Cattaneo
 */
public class TorusRuleTest {

    @Test
    public void testNegativeRowValidCol() {
        Grid grid = new Grid(10,20);
        TorusRule rule = new TorusRule();

        int[] result1 = rule.validate(grid, -1, 0);
        assertEquals(result1[0], 9);
        assertEquals(result1[1], 0);

        int[] result2 = rule.validate(grid, -2, 10);
        assertEquals(result2[0], 8);
        assertEquals(result2[1], 10);
    }

    @Test
    public void testNegativeColumnValidRow() {
        Grid grid = new Grid(10,20);
        TorusRule rule = new TorusRule();

        int[] result1 = rule.validate(grid, 5, -1);
        assertEquals(result1[0], 5);
        assertEquals(result1[1], 19);
    }

    @Test
    public void testBothOutOfBound() {
        Grid grid = new Grid(10, 20);
        TorusRule rule = new TorusRule();

        int[] result1 = rule.validate(grid, -1,-1);
        assertEquals(result1[0], 9);
        assertEquals(result1[1], 19);
    }

    @Test public void testValidPositions() {
        Grid grid = new Grid(10, 20);
        TorusRule rule = new TorusRule();

        int[] result1 = rule.validate(grid, 5,5);
        assertEquals(result1[0], 5);
        assertEquals(result1[1], 5);

        int[] result2 = rule.validate(grid, 9,19);
        assertEquals(result2[0], 9);
        assertEquals(result2[1], 19);
    }
}
