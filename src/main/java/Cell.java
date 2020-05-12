package src.main.java;

/**
 *
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

    public String giveString() {
        if (this.state == State.ALIVE) {
            return "X";
        } else {
            return "O";
        }
    }
}
