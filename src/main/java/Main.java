package src.main.java;

/**
 * The class from which the application runs.
 */
public class Main {

    private Main() {
        // Not to be instantiated
    }

    /**
     * Run the application.
     * @param args the command line arguments
     * @throws InterruptedException Exception for the step timer
     */
    public static void main(final String[] args) throws InterruptedException {
        // Model

        final GameOfLife game = new GameOfLife(80, 80);


        // GUI
        final MainFrame frame = new MainFrame(game, 10);
        frame.setVisible(true);

        while( true ) {
            game.step();

        }
    }



}
