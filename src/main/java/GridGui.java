package src.main.java;

import javax.swing.*;
import java.awt.*;

public class GridGui extends JPanel {
    private final Grid grid;
    private final int rows;
    private final int cols;
    private final int squareSize;
    final int[] dim;

    public GridGui(final Grid grid, final int squareSize) {
        this.grid = grid;
        this.rows = grid.getRows();
        this.cols = grid.getColumns();
        this.squareSize = squareSize;
        this.dim = new int[2];

        final int width = (cols * squareSize);
        final int height = (rows * squareSize) + (rows);
        dim[0] = width;
        dim[1] = height;
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

    public int[] getDimensions() {
        return dim;
    }
}
