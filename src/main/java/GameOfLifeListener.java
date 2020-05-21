package src.main.java;

/**
 * Listener used to catch when a grid changed.
 */
public interface GameOfLifeListener {

    /**
     * Method called when there is a change in
     * the Grid.
     */
    void gridChanged();

}
