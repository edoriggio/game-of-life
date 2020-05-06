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
        // currentGrid().populate()
    }

    public void step() {
        // modify nextStepGrid according to the state of currentGrid
        currentGrid.calculateNext(nextStepGrid);
        // now nextStep grid is the grid that we want to be displayed the next step
        // therefore we need to swap the references
        Grid temp = currentGrid;
        currentGrid = nextStepGrid;
        nextStepGrid = temp;
    }

    public void displayCurrentGrid() {
        // currentGrid.print()
    }

}
