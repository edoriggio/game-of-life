package src.main.java;

import javax.swing.*;
import java.awt.*;

public class GridGui extends JPanel implements GameOfLifeListener {
    private final GameOfLife gameOfLife;
    private final int rows;
    private final int cols;
    private final int squareSize;

    public GridGui(final GameOfLife gameOfLife, final int squareSize) {
        this.gameOfLife = gameOfLife;
        this.rows = gameOfLife.getCurrentGrid().getRows();
        this.cols = gameOfLife.getCurrentGrid().getColumns();
        this.squareSize = squareSize;

        final int width = (rows * squareSize);
        final int height = (cols * squareSize);

        setPreferredSize(new Dimension(width, height));

        gameOfLife.addGameOfLifeListener(this);
    }

    public void paint(Graphics g) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                State state = gameOfLife.getCurrentGrid().getCell(x, y).getState();
                Color background = (state == State.ALIVE) ? Color.black : Color.white;
                Color border = (state == State.ALIVE) ? Color.white : Color.black;

                g.setColor(background);
                g.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);

                g.setColor(border);
                g.drawRect(x * squareSize, y * squareSize, squareSize, squareSize);
            }
        }
    }

    @Override
    public void gridChanged() {
        repaint();
    }
}
