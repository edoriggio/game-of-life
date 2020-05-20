package src.main.java;
import java.util.ArrayList;

/**
 * Class used to represent a game of life.
 * It is represented by two parallel Grids ( bidimentional arrays ) one holding the current state
 * ( the once to be shown ) while the other is used to hold the next state to be shown based on the first one.
 * At each step the two grids change their roles.
 */
public class GameOfLife {

    private Grid grid1;
    private Grid grid2;
    private final BorderRule borderRule;
    private final Neighborhood neighbourRule;
    private final ArrayList<GameOfLifeListener> listeners;

    /**
     * Constructor for the class GameOfLife. Instantiate an empty GameOfLife ( all Cells are DEAD ).
     * @param rows the number of rows in the Grid
     * @param cols the number of columns in the Grid
     */
    public GameOfLife(int rows, int cols) {
        grid1 = new Grid(rows, cols);
        grid2 = new Grid(rows, cols);
        borderRule = new TorusRule();
        neighbourRule = new MooreNeighborhood(borderRule);
        this.listeners = new ArrayList<>();
        randomlyPopulate();
    }

    /**
     * Randomly assign a State to each Cell in the Grid of this.
     */
    public void randomlyPopulate() {
        for (int i = 0; i < grid1.getRows(); i++) {
            for (int j = 0; j < grid1.getColumns(); j++) {
                grid1.getCell(i, j).setState(Math.random() < 0.6 ? State.DEAD : State.ALIVE);
            }
        }

        notifyGridChanged();
    }

    /**
     * Clear the current Grid ( set all Cells to be DEAD ).
     */
    public void clearGrid() {
        for (int i = 0; i < grid1.getRows(); i++) {
            for (int j = 0; j < grid1.getColumns(); j++) {
                grid1.getCell(i, j).setState(State.DEAD);
            }
        }

        notifyGridChanged();
    }

    /**
     * Get the current Grid of this.
     * @return the current Grid of Cells.
     */
    public Grid getCurrentGrid() {
        return grid1;
    }

    /**
     * Compute a step of the game of life game.
     */
    public void step() {
        Compute.computeNextGrid(neighbourRule, grid1, grid2);
        Grid temp = grid1;
        grid1 = grid2;
        grid2 = temp;
        notifyGridChanged();
    }

    /**
     * Add a GameOfLifeListener to this.
     * @param listener the Listener that needs to listen to changes happening to this.
     */
    public void addGameOfLifeListener(final GameOfLifeListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Notify all listeners attached to this that the status has changed.
     */
    public void notifyGridChanged() {
        for (GameOfLifeListener listener : listeners) {
            listener.gridChanged();
        }
    }

    public void addPattern(final Pattern pattern, final int i, final int j) {
        Insert.insertPattern(pattern, this.grid1, this.borderRule, i, j);
    }
}
