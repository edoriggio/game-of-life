package src.main.java;

import javax.swing.*;
import java.awt.*;

public class GridGui extends JPanel {
    private final Grid grid;
    private final int rows;
    private final int cols;
    private final int squareSize;

    public GridGui(final Grid grid, final int squareSize) {
        this.grid = grid;
        this.rows = grid.getRows();
        this.cols = grid.getColumns();
        this.squareSize = squareSize;
    }

    public void paint(Graphics g) {
        for (int x = 0; x < cols+1; x++) {
            for (int y = 0; y < rows+1; y++) {
                g.setColor(Color.black);
                if (grid.getCell(x, y) != null) {
                    if (grid.getCell(x, y).getState() == State.ALIVE) {
                        g.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);
                        g.setColor(Color.white);
                    }
                    g.drawRect(x * squareSize, y * squareSize, squareSize, squareSize);
                }
            }
        }
    }
}
