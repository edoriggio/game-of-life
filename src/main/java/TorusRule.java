package src.main.java;

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
