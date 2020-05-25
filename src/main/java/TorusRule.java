package src.main.java;

/**
 * This BorderRule represents the grid as if it has a torus shape, meaning that the first row
 * is neighboring the last row and the first column is neighboring the last column.
 *
 * @author Michele Cattaneo
 */
public class TorusRule extends BorderRule {

    @Override
    public int[] validate(final Grid grid, final int i, final int j) {
        final int rows = grid.getRows();
        final int cols = grid.getColumns();
        final int validatedIndexI = (i + rows) % rows;
        final int validatedIndexJ = (j + cols) % cols;
        return new int[]{validatedIndexI, validatedIndexJ};
    }

}
