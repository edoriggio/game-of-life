package src.main.java;

public abstract class PatternFactory {
    final int rowsNeeded;
    final int colsNeeded;
    int[] rowPositions;
    int[] colPositions;
    BorderRule borderRule;

    /**
     * Constructor for a generic PatternFactory.
     * @param i the rows needed by the concrete Pattern
     * @param j the columns needed by the concrete Pattern
     * @param rule the BorderRule applied to the grid
     */
    public PatternFactory(int i, int j, BorderRule rule) {
        rowsNeeded = i;
        colsNeeded = j;
        borderRule = rule;
    }

    /**
     * Insert the specific pattern of the concrete class in the given grid at the given position.
     * A pattern can be placed only if there's enough space, meaning that each pattern requires a certain
     * amount of rows and columns. Also the given position must be in bound of the grid.
     * @param grid the grid where the pattern will be placed
     * @param i the row position
     * @param j the column position
     * @return true if the placing was successful, false otherwise
     */
    public abstract boolean insertPattern(Grid grid, int i, int j);
}
