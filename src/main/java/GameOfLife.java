package src.main.java;

import java.util.ArrayList;

public class GameOfLife {

    private Grid grid1;
    private Grid grid2;
    private final BorderRule borderRule;
    private final Neighborhood neighbourRule;
    private final ArrayList<GameOfLifeListener> listeners;

    public GameOfLife(int rows, int cols) {
        grid1 = new Grid(rows, cols);
        grid2 = new Grid(rows, cols);
        borderRule = new TorusRule();
        neighbourRule = new MooreNeighborhood(borderRule);
        this.listeners = new ArrayList<>();
//        randomlyPopulate();
        addGlider(0, 0);
        addGlider(5, 5);
        addGlider(10, 10);
        randomlyPopulate();
    }

    private void randomlyPopulate() {
        for (int i = 0; i < grid1.getRows(); i++) {
            for (int j = 0; j < grid1.getColumns(); j++) {
                grid1.getCell(i, j).setState(Math.random() < 0.6 ? State.DEAD : State.ALIVE);
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
        notifyGridChanged();
    }

    public void addGameOfLifeListener(final GameOfLifeListener listener) {
        this.listeners.add(listener);
    }

    public void notifyGridChanged() {
        for (GameOfLifeListener listener : listeners) {
            listener.gridChanged();
        }
    }

    public void addGlider(int i, int j) {
        PatternFactory glider = new GliderPattern(borderRule);

        glider.insertPattern(grid1, i, j);
    }
}
