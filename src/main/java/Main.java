package src.main.java;

import src.main.java.gui.MainFrame;

/**
 * The class from which the application runs.
 *
 * @author Edoardo Riggio
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
        final GameOfLife game = new GameOfLife(90, 90);

        // GUI
        final MainFrame frame = new MainFrame(game, 10);
        frame.setVisible(true);

        // start executing steps of the instance of GameOfLife
        game.startExecutingSteps();

    }



}
