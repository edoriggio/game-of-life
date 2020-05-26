package src.main.java;

/**
 * A cell is the most basic block of the Game of Life.
 * This cell has a status and can interact with neighboring cells.
 *
 * @author Edoardo Riggio
 */
public class Cell {

    private State state;

    /**
     * Constructor of the class Cell.
     * @param state The state of the cell
     */
    public Cell(final State state) {
        this.state = state;
    }

    /**
     * Given a state, change the current state of the Cell.
     * @param state The new state of the Cell
     */
    public void setState(final State state) {
        this.state = state;
    }

    /**
     * Get the current state of a Cell.
     * @return The state of the Cell
     */
    public State getState() {
        return this.state;
    }

}
