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
        final GameOfLife game = new GameOfLife(70, 80);

        // GUI
        final FrameMain frame = new FrameMain(game, 10);
        frame.setVisible(true);

        runGame(game);
    }

    /**
     * Run a game of life instance.
     * @param game the GameOFLife to be run.
     * @throws InterruptedException Interruption exception to be thrown.
     */
    public static void runGame(GameOfLife game) throws InterruptedException {
        while (true) {
            Thread.sleep(10);
            if (!game.isPaused()) {
                game.step();
            }
        }
    }

}
