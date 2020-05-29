package src.test.java;

import org.junit.Before;
import org.junit.Test;
import src.main.java.*;

/**
 * Test class for the class PatternAdder.
 *
 * @author Michele Cattaneo
 */
public class PatternAdderTest {
    private Grid grid;
    private BorderRule rule;

    @Before
    public void setUp() {
        grid = new Grid(100,100);
        rule = new TorusRule();

    }

    @Test
    public void testInsertOfEveryPattern() throws PatternException {
        for (Pattern p : Pattern.values()) {
            PatternAdder.insertPattern(p, grid, rule, 0,0);
            System.out.println(p.getName());
        }
    }


}
