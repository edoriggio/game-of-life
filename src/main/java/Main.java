package src.main.java;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Main extends JFrame {

    private Main() {
        super("Game of Life");
        displayGui();
    }

    /**
     * Run the application.
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        new Main();
    }

    public void displayGui() {
        Container content = getContentPane();
        final GameOfLife game = new GameOfLife(10, 10);
        final Grid grid = game.getCurrentGrid();
        final GridGui gui = new GridGui(grid, 30);
        content.add(gui);

        pack();
        setVisible(true);
    }
}
