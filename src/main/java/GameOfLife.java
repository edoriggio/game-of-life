package src.main.java;

import java.util.ArrayList;

/**
 * Class used to represent a game of life. It is represented by two
 * parallel Grids (bi-dimensional arrays) one holding the current
 * state (the once to be shown) while the other is used to hold the
 * next state to be shown based on the first one. At each step the
 * two grids change their roles.
 */
public class GameOfLife {

    private Grid grid1;
    private Grid grid2;
    private final BorderRule borderRule;
    private final Neighborhood neighbourRule;
    private final ArrayList<GameOfLifeListener> listeners;
    private int speed;
    private final int maxTimeBetweenSteps;
    private boolean paused;

    /**
     * Constructor for the class GameOfLife. Instantiate an empty
     * GameOfLife (all Cells are set to State.DEAD).
     * @param rows The number of rows in the Grid
     * @param cols The number of columns in the Grid
     */
    public GameOfLife(final int rows, final int cols) {
        grid1 = new Grid(rows, cols);
        grid2 = new Grid(rows, cols);
        borderRule = new TorusRule();
        neighbourRule = new MooreNeighborhood(borderRule);
        this.listeners = new ArrayList<>();
        this.speed = 1000;
        this.maxTimeBetweenSteps = 1100;
        this.paused = false;

    }

    /**
     * Randomly assign a State to each Cell in the Grid of 'this'.
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
     * Clear the current Grid (set all Cells to State.DEAD).
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
     * Get the current Grid of 'this'.
     * @return The current Grid of Cells.
     */
    public Grid getCurrentGrid() {
        return grid1;
    }

    /**
     * Compute a step of game of life.
     * @throws InterruptedException Exception for Thread.sleep()
     */
    public void step() throws InterruptedException {
        Compute.computeNextGrid(neighbourRule, grid1, grid2);
        final Grid temp = grid1;
        grid1 = grid2;
        grid2 = temp;
        notifyGridChanged();
        Thread.sleep(maxTimeBetweenSteps - speed);
    }

    /**
     * Add a GameOfLifeListener to 'this'.
     * @param listener Listens to changes happening to 'this'.
     */
    public void addGameOfLifeListener(final GameOfLifeListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Notify all listeners attached to this that the status has changed.
     */
    public void notifyGridChanged() {
        for (final GameOfLifeListener listener : listeners) {
            listener.gridChanged();
        }
    }

    /**
     * Add a pattern to a grid, given a pattern type, an x coordinate and a
     * y coordinate.
     * @param pattern The type of pattern to be inserted
     * @param i The x coordinate of the pattern
     * @param j The y coordinate of the pattern
     */
    public void addPattern(final Pattern pattern, final int i, final int j) {
        try {
            PatternInsert.insertPattern(pattern, this.grid1, this.borderRule, i, j);
        } catch (final PatternException exception) {
            new FrameError("The pattern you are trying to insert does not fit");
        }
    }

    /**
     * Change the speed of the animation.
     * @param delta The increase rate
     */
    public void changeSpeed(final int delta) {
        final int newSpeed = this.speed + delta;
        this.speed = newSpeed < this.maxTimeBetweenSteps && newSpeed > 0 ? newSpeed : this.speed;
    }

    /**
     * Getter for the speed of the animation.
     * @return The speed of the animation
     */
    public Integer getSpeed() {
        return this.speed;
    }

    /**
     * Set this GameOfLife to be paused if it's currently unpaused and vice versa.
     */
    public void pauseOrPlayGame() {
        this.paused = !this.paused;
    }

    /**
     * Check whether this GameOfLife is currently paused.
     * @return true if this is paused, false otherwise
     */
    public boolean isPaused() {
        return this.paused;
    }

}
