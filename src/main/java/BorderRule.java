package src.main.java;

public abstract class BorderRule {

    /**
     * Validate the given position i,j in the grid according to the BorderRule.
     * @param grid the grid containing the position
     * @param i the index of the row
     * @param j the index of the column
     * @return the same j,i if is a valid position according to the rule, the corrected position otherwise
     */
    public abstract int[] validate(Grid grid, int i, int j);
}
