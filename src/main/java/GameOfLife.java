package src.main.java;

public class GameOfLife {

    private Grid grid1;
    private Grid grid2;
    private final BorderRule borderRule;
    private final Neighborhood neighbourRule;

    public GameOfLife(int rows, int cols) {
        grid1 = new Grid(rows, cols);
        grid2 = new Grid(rows, cols);
        borderRule = new TorusRule();
        neighbourRule = new MooreNeighborhood(borderRule);
        randomlyPopulate();
    }

    private void randomlyPopulate() {
        for (int i = 0; i < grid1.getRows(); i++) {
            for (int j = 0; j < grid1.getColumns(); j++) {
                grid1.getCell(i, j).setState(Math.random() * 10 < 5 ? State.DEAD : State.ALIVE);
            }
        }
    }

    public Grid getCurrentGrid() {
        return grid1;
    }

    public void step() {
        Compute.computeNextGrid(neighbourRule, grid1, grid2);
        Grid temp = grid1;
        grid1 = grid2;
        grid2 = temp;
    }
}
