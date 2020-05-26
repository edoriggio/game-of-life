package src.main.java;

import src.main.java.patterns.*;

import java.beans.beancontext.BeanContext;

/**
 * This class is responsible to understand the type of pattern.
 * Given this pattern, it will insert it inside of a grid.
 *
 * @author Edoardo Riggio
 */
public class PatternInsert {

    private PatternInsert() {
        // Not to be initialized
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
                success = new CircleOfFirePattern(borderRule).insertPattern(grid, i, j);
                break;
            case DOUBLECIRCLEOFFIRE:
                success = new DoubleCircleOfFirePattern(borderRule).insertPattern(grid, i, j);
                break;
            case TUB:
                success = new TubPattern(borderRule).insertPattern(grid, i, j);
                break;
            case BOAT:
                success = new BoatPattern(borderRule).insertPattern(grid, i, j);
                break;
            case BLINKER:
                success = new BlinkerPattern(borderRule).insertPattern(grid, i, j);
                break;
            case TOAD:
                success = new ToadPattern(borderRule).insertPattern(grid, i, j);
                break;
            case BEACON:
                success = new BeaconPattern(borderRule).insertPattern(grid, i, j);
                break;
            case LWSS:
                success = new LWSSPattern(borderRule).insertPattern(grid, i, j);
                break;
            default:
                System.out.print(pattern.toString());
                throw new PatternException("Pattern not found");
        }

        if (!success) {
            throw new PatternException("Pattern could not fit the current Grid");
        }
    }
    
}
