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
        GameOfLife game = new GameOfLife(20, 20);

        // GUI
        MainFrame frame = new MainFrame(game, 10);
        frame.setVisible(true);

        for (int i = 0; i < 2000; i++) {
            game.step();
            Thread.sleep(100);
        }
    }
}
