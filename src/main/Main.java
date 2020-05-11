package src.main;

/**
 * ...
 */
public class Main {

    private Main() {
        // never instantiated
    }

    /**
     * Run the application (from the command line).
     * @param args the command line arguments
     */
    public static void main(final String[] args) {


        final GameOfLife model = new GameOfLife();

        final TextUserInterface tui = new TextUserInterface(model);
        tui.run();

    }

}
