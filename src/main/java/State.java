package src.main.java;

/**
 * A cell can have different states. This enumeration class
 * defines the different states a cell can have.
 *
 * @author Edoardo Riggio
 */
public enum State {

    ALIVE("alive"),
    DEAD("dead");

    private final String name;

    /**
     * Initialize the state.
     * @param name The name of the state
     */
    State(final String name) {
        this.name = name;
    }

    /**
     * Give a human-readable representation of the cell state.
     * @return The human-readable state
     */
    public String getName() {
        return name;
    }

}
