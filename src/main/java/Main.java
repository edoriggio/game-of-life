package src.main.java;

/**
 *
 */
public class Main {

    /**
     * Run the application.
     * @param args the command line arguments
     */
    public static void main(final String[] args) throws InterruptedException {
        // Model
        GameOfLife game = new GameOfLife(10, 10);

        // GUI
        MainFrame frame = new MainFrame(game, 30);
        frame.setVisible(true);

        for (int i = 0; i < 100; i++) {
            game.step();
            Thread.sleep(250);
        }
    }
}
