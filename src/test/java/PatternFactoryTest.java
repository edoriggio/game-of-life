package src.test.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.main.java.*;
import src.main.java.patterns.GliderPattern;
import src.main.java.patterns.GosperGliderGunPattern;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertFalse;

/**
 * Test class for PatternFactory class.
 *
 * @author Michele Cattaneo
 */
public class PatternFactoryTest {
    Grid grid;
    BorderRule borderRule;
    PatternFactory factory;
    final int[] rowPositions = new int[]{0,1,1,2,2};
    final int[] colPositions = new int[]{2,0,2,2,1};

    @Before
    public void setUp() {
        grid = new Grid(10, 10);
        borderRule = new TorusRule();
        factory = new GliderPattern(borderRule);

        for (int i = 0; i < grid.getRows(); i++ ) {
            for (int j = 0; j < grid.getColumns(); j++ ) {
                grid.getCell(i, j).setState(State.DEAD);
            }
        }
        System.out.println("Set up test grid and factory..");
    }

    @After
    public void tearDown() {
        for (int i = 0; i < grid.getRows(); i++ ) {
            for (int j = 0; j < grid.getColumns(); j++ ) {
                grid.getCell(i, j).setState(State.DEAD);
            }
        }
        System.out.println("Teared down, ready for new test..");
    }

    @Test
    public void gliderInRangeTest() {
        factory.insertPattern(grid, 1 ,1);

        for (int k = 0; k < rowPositions.length; k++) {
            assertSame(grid.getCell(1 + rowPositions[k], 1 + colPositions[k]).getState(), State.ALIVE);
        }
        //grid.printGrid();
    }

    @Test
    public void gliderTestBorder() {

        // Try to place a glider at the right border of the grid
        factory.insertPattern(grid, 0, 9);
        for (int k = 0; k < rowPositions.length; k++) {
            //compute the validated row and col according to the rule
            int[] positions = borderRule.validate(grid, rowPositions[k], 9 + colPositions[k]);
            int row = positions[0];
            int col = positions[1];
            assertSame(grid.getCell(row, col).getState(), State.ALIVE);
        }
    }

    @Test
    public void testPatternTooBig() {
        PatternFactory factory2 = new GosperGliderGunPattern(borderRule);
        assertFalse(factory2.insertPattern(grid,0,0));
    }

    @Test
    public void testIndexOutOfBound() {
        assertFalse(factory.insertPattern(grid, 20,20));
    }

}
