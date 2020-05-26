package src.main.java.gui;

import src.main.java.GameOfLife;
import src.main.java.GameOfLifeListener;
import src.main.java.State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class is responsible of building a JPanel on which a grid
 * if drawn. This grid will have a black square for each alive cell
 * a a white square for each dead cell.
 *
 * @author Edoardo Riggio
 */
public class GridPanel extends JPanel implements GameOfLifeListener {
    private final GameOfLife gameOfLife;
    private final int rows;
    private final int cols;
    private final int squareSize;

    /**
     * Constructor for the GridPanel class.
     * @param gameOfLife A game of life instance
     * @param squareSize The size of the squares of the grid
     */
    public GridPanel(final GameOfLife gameOfLife, final int squareSize) {
        super();
        this.gameOfLife = gameOfLife;
        this.rows = gameOfLife.getCurrentGrid().getRows();
        this.cols = gameOfLife.getCurrentGrid().getColumns();
        this.squareSize = squareSize;

        final int height = rows * squareSize;
        final int width = cols * squareSize;

        setPreferredSize(new Dimension(width, height));

        gameOfLife.addGameOfLifeListener(this);
    }

    /**
     * Method to draw the grid.
     * @param g The Graphics used by java to draw
     */
    public void paint(final Graphics g) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                final State state = gameOfLife.getCurrentGrid().getCell(x, y).getState();
                final Color background = (state == State.ALIVE) ? Color.black : Color.white;
                final Color border = (state == State.ALIVE) ? Color.white : Color.black;

                g.setColor(background);
                g.fillRect(y * squareSize, x * squareSize, squareSize, squareSize);

                g.setColor(border);
                g.drawRect(y * squareSize, x * squareSize, squareSize, squareSize);
            }
        }
    }

    @Override
    public void gridChanged() {
        repaint();
    }
}
