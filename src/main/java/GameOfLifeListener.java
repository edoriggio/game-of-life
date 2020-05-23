package src.main.java;

/**
 * Listener used to catch when a grid changed.
 *
 * @author Edoardo Riggio
 * @version 24/05/2020
 */
public interface GameOfLifeListener {

    /**
     * Method called when there is a change in
     * the Grid.
     */
    void gridChanged();

}
