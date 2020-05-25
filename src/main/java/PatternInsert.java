package src.main.java;

import src.main.java.patterns.*;

/**
 * This class is responsible to understand the type of pattern.
 * Given this pattern, it will insert it inside of a grid.
 *
 * @author Edoardo Riggio
 * @version 24/05/2020
 */
public class PatternInsert {

    private PatternInsert() {
        // Not to be instantiated
    }

    /**
     * PatternInsert a pattern into a grid given its name.
     * @param pattern The type of pattern to be inserted
     * @param grid The grid onto which the pattern needs to be placed
     * @param borderRule The border rule to be used
     * @param i The x coordinate
     * @param j The y coordinate
     * @throws PatternException Throw an exception if the pattern is bigger than the grid
     */
    public static void insertPattern(final Pattern pattern, final Grid grid,
                                     final BorderRule borderRule,
                                     final int i, final int j) throws PatternException {

        final boolean success;

        switch (pattern) {
            case BLOCK:
                success = new BlockPattern(borderRule).insertPattern(grid, i, j);
                break;
            case BEEHIVE:
                success = new BeehivePattern(borderRule).insertPattern(grid, i, j);
                break;
            case LOAF:
                success = new LoafPattern(borderRule).insertPattern(grid, i, j);
                break;
            case GLIDER:
                success = new GliderPattern(borderRule).insertPattern(grid, i, j);
                break;
            case PUFFER:
                success = new PufferPattern(borderRule).insertPattern(grid, i, j);
                break;
            case GOSPERGLIDERGUN:
                success = new GosperGliderGunPattern(borderRule).insertPattern(grid, i, j);
                break;
            case HEXAPOLE:
                success = new HexapolePattern(borderRule).insertPattern(grid, i, j);
                break;
            case CIRCLEOFFIRE:
                success = new CircleOfFirePattern(borderRule).insertPattern(grid,i, j);
                //new CircleOfFirePattern(borderRule).insertPattern(grid, i+8, j+8);
                break;
            case DOUBLECIRCLEOFFIRE:
                success = new DoubleCircleOfFire(borderRule).insertPattern(grid, i, j);
                break;
            default:
                throw new PatternException("Pattern not found");
        }

        if (!success) {
            throw new PatternException("Pattern could not fit the current Grid");
        }
    }
    
}
