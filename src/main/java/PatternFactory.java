package src.main.java;

/**
 * A PatternFactory is used generate a game of life pattern and add it to a Grid.
 * Each subclass represents a specific pattern defined by two vectors ( arrays ) with the
 * corresponding row and column positions of each cell, starting at position grid[0][0].
 * rowPosition[k] gives the row index of the k-th cell while colPosition[k] the column position.
 * This class also depends on a BorderRule instance to re-direct cells that would be otherwise out of
 * bounds in the grid.
 *
 * @author Michele Cattaneo
 * @version 20.05.2020
 */
public class PatternFactory {
    final int rowsNeeded;
    final int colsNeeded;
    int[] rowPositions;
    int[] colPositions;
    final BorderRule borderRule;

    /**
     * Constructor for a generic PatternFactory.
     * @param i the rows needed by the concrete Pattern
     * @param j the columns needed by the concrete Pattern
     * @param rule the BorderRule applied to the grid
     */
     PatternFactory(int i, int j, BorderRule rule) {
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
            int[] position = borderRule.validate(grid, i + rowPositions[k], j + colPositions[k]);
            int rowToDraw = position[0];
            int colToDraw = position[1];
            // draw the validated position ( set it as ALIVE )
            grid.getCell(rowToDraw, colToDraw).setState(State.ALIVE);
        }

        return true;
    }
}