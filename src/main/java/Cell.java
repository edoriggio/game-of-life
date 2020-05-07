package src.main.java;

public class Cell {

    private boolean alive;

    /**
     * Constructor for cells.
     * @param alive Indicates whether a cell is alive or not
     */
    public Cell(final boolean alive) {
        this.alive = alive;
    }

    /**
     * Check (using the game of life's rules) whether a cell
     * should be alive or dead.
     * @param neighbors The number of neighbors of a cell
     * @return A new cell with the updated state
     */
    public Cell check(final int neighbors) {
        // TODO: Implement check method
        return new Cell(true);
    }

    /**
     * Get the state of a cell.
     * @return True if a cell is alive
     *         False otherwise
     */
    public boolean isAlive() {
        return alive;
    }

    // Ask if it is better to return a Cell
    // or bool in check()

    // public void setAlive(boolean alive) {
    //     this.alive = alive;
    // }

    /**
     * Kill this cell.
     */
    public void kill() {
        alive = false;
    }
}
