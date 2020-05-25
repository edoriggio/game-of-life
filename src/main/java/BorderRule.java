package src.main.java;

/**
 * A BorderRule defines how a certain position, that might be
 * outside of the bounds of a grid, gets redirected into a new
 * position that actually is in bound.
 *
 * @author Michele Cattaneo
 */
public abstract class BorderRule {

    /**
     * Validate the given position i,j in the grid according to the BorderRule.
     * @param grid The grid containing the position
     * @param i The index of the row
     * @param j The index of the column
     * @return The same i,j if is a valid position according to the rule,
     *         The corrected position otherwise
     */
    public abstract int[] validate(Grid grid, int i, int j);
}
