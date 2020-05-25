package src.main.java;

/**
 * A PatternFactory is used generate a game of life pattern and add it to a Grid.
 * Each subclass represents a specific pattern defined by two vectors (arrays) with the
 * corresponding row and column positions of each cell, starting at position grid[0][0].
 * rowPosition[k] gives the row index of the k-th cell while colPosition[k] the column
 * position. This class also depends on a BorderRule instance to re-direct cells that
 * would be otherwise out of bounds in the grid.
 *
 * @author Michele Cattaneo
 */
public class PatternFactory {
    private final int rowsNeeded;
    private final int colsNeeded;
    public int[] rowPositions;
    public int[] colPositions;
    private final BorderRule borderRule;

    /**
     * Constructor for a generic PatternFactory.
     * @param i the rows needed by the concrete Pattern
     * @param j the columns needed by the concrete Pattern
     * @param rule the BorderRule applied to the grid
     */
    protected PatternFactory(final int i, final int j, final BorderRule rule) {
        this.rowsNeeded = i;
        this.colsNeeded = j;
        this.borderRule = rule;
    }

    /**
     * PatternInsert the specific pattern of the concrete class in the given grid
     * at the given position. A pattern can be placed only if there's enough space,
     * meaning that each pattern requires a certain amount of rows and columns. Also
     * the given position must be in bound of the grid.
     * @param grid the grid where the pattern will be placed
     * @param i the row position
     * @param j the column position
     * @return true if the placing was successful, false otherwise
     */
    public boolean insertPattern(final Grid grid, final int i, final int j) {
        // if there's not enough space
        if (grid.getRows() < this.rowsNeeded || grid.getColumns() < this.colsNeeded) {
            return false;
        }

        if (i < 0 || j < 0 || i >= grid.getRows() || j >= grid.getColumns()) {
            return false;
        }

        for (int k = 0; k < rowPositions.length; k++) {
            // validate the position of the block of the pattern added by the i,j position desired
            final int[] position = borderRule.validate(grid,
                    i + rowPositions[k], j + colPositions[k]);
            final int rowToDraw = position[0];
            final int colToDraw = position[1];
            // draw the validated position ( set it as ALIVE )
            grid.getCell(rowToDraw, colToDraw).setState(State.ALIVE);
        }

        return true;
    }

}
