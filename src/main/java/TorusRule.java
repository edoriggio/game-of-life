package src.main.java;

/**
 * This BorderRule represents the grid as if it has a torus shape, meaning that the first row
 * is neighboring the last row and the first column is neighboring the last column.
 *
 * @author Michele Cattaneo
 * @version 20.05.2020
 */
public class TorusRule extends BorderRule {

    @Override
    public int[] validate(Grid grid, int i, int j) {
        int rows = grid.getRows();
        int cols = grid.getColumns();
        int validatedIndexI = (i + rows) % rows;
        int validatedIndexJ = (j + cols) % cols;
        return new int[]{validatedIndexI, validatedIndexJ};
    }
}
