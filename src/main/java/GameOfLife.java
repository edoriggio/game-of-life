package src.main.java;

import src.main.java.gui.ErrorFrame;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class used to represent a game of life. It is represented by two
 * parallel Grids (bi-dimensional arrays) one holding the current
 * state (the once to be shown) while the other is used to hold the
 * next state to be shown based on the first one. At each step the
 * two grids change their roles.
 *
 * @author Michele Cattaneo
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
    private TimerTask timerTask;

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
        //startExecutingSteps();

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
     */
    public void step() {
        // compute the new grid into grid2 depending on the state of grid1
        Compute.computeNextGrid(neighbourRule, grid1, grid2);

        // grid2 now contains the actual grid that we want to be shown at the beginning of next step
        // therefore we swap the two references:
        final Grid temp = grid1;
        grid1 = grid2;
        grid2 = temp;
        notifyGridChanged();

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
            notifyGridChanged();
        } catch (final PatternException exception) {
            new ErrorFrame("The pattern you are trying to insert does not fit");
        }
    }

    /**
     * Change the speed of the animation.
     * @param delta The increase rate
     */
    public void changeSpeed(final int delta) {
        final int newSpeed = this.speed + delta;
        this.speed = newSpeed < this.maxTimeBetweenSteps && newSpeed > 0 ? newSpeed : this.speed;
        // if the new speed was valid, we set 'speed' to have a different value,
        // but the Timer is still executing the TimerTask at the rate specified by the previous
        // value of speed. Therefore we stop executing steps and start again so that the timer
        // will execute the TimerTask with a rate that depends on the new value of 'speed'.
        stopExecutingSteps();
        startExecutingSteps();
    }

    /**
     * Getter for the speed of the animation.
     * @return The speed of the animation
     */
    public Integer getSpeed() {
        return this.speed;
    }

    /**
     * Start executing steps of the game if the game is currently not.
     * Stop executing steps of the game if the game is currently running.
     */
    public void pauseOrPlayGame() {

        if (paused) {
            startExecutingSteps();
        } else {
            stopExecutingSteps();
        }
        // swap the value of 'paused'
        this.paused = !this.paused;
    }

    /**
     * Check whether this GameOfLife is currently paused.
     * @return true if this is paused, false otherwise
     */
    public boolean isPaused() {
        return this.paused;
    }

    /**
     * Execute steps of the game with a period that depends on the field 'speed'.
     */
    public void startExecutingSteps() {
        // Instantiate a TimerTask for a Timer that executes a step of Game of Life.
        timerTask = new TimerTask() {
            // this method will execute a step of the game
            @Override
            public void run() {
                step();
            }
        };
        // Execute the TimerTask defined above at the specified rate.
        new Timer().scheduleAtFixedRate(timerTask, 0, maxTimeBetweenSteps - speed);
    }

    /**
     * Stop the execution of new steps of the game.
     */
    public void stopExecutingSteps() {
        // by canceling the TimeTask, no new steps will be executed.
        timerTask.cancel();
    }

}
