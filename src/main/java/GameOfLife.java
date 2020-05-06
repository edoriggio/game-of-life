package src.main.java;

public class GameOfLife {

    private Grid currentGrid;
    private Grid nextStepGrid;
    private final int[] neighbouringColumnRule;
    private final int[] neighbouringRowRule;

    public GameOfLife(final int rows, final int cols) {
        currentGrid = new Grid(rows, cols);
        nextStepGrid = new Grid(rows, cols);
        neighbouringRowRule = new int[]{-1, +1, 0, 0};
        neighbouringColumnRule = new int[]{0, 0, +1, -1};

    }

    private void randomlyPopulateGrid() {
        // fill random positions with live cells
    }

    public void step() {
        // for each cell, compute the new value of it ( 0 or 1 ) for the next step
        // put the value in nextStepGrid
        // swap reference between currentGrid and nextStepGrid, so that for
        // the next step we have the updated grid as current
    }

    public void displayCurrentGrid() {
        // currentGrid.print()
    }

}
