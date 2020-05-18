package src.main.java;

public class GliderPattern extends PatternFactory{

    /**
     * Constructor for a GliderPattern.
     * @param rule the BorderRule to be applied
     */
    public GliderPattern(BorderRule rule) {
        super(4,3, rule);
        rowPositions = new int[]{0,1,1,2,2};
        colPositions = new int[]{2,0,2,2,1};
    }

    /**
     * Insert a specific pattern in the given grid at the given position i,j.
     * @param grid the grid that will be drawn
     * @param i the row position
     * @param j the col position
     * @return true if drawing was successful, false otherwise.
     */
    @Override
    public boolean insertPattern(Grid grid, int i, int j) {
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
