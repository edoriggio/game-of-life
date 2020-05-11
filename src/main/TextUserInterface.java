package src.main;

/**
 * ...
 */
public class TextUserInterface {

    private final GameOfLife model;


    /**
     * Create a new TUI operating on the given Model.
     * @param model The model of this application
     */
    public TextUserInterface(final GameOfLife model) {
        this.model = model;
    }

    /**
     * Run the application.
     */
    public void run() {
        System.out.println("Welcome to " + model.toString());
    }

}
