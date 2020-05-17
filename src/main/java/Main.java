package src.main.java;

import javax.swing.*;

/**
 *
 */
public class Main extends JFrame {

    private Main() {
        final GameOfLife game = new GameOfLife(10, 10);
        final Grid grid = game.getCurrentGrid();
        GridGui xyz = new GridGui(grid, 30);
        add(xyz);
        pack();
    }

    /**
     * Run the application (from the command line).
     * @param args the command line arguments
     */
    public static void main(final String[] args) {

        new Main().setVisible(true);

    }
}
