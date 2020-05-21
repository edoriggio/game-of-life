package src.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is responsible of creating the JFrame on which
 * the application is built.
 */
public class MainFrame extends JFrame {

    /**
     * Constructor for the MainFrame class.
     * @param gameOfLife An instance of game of life
     * @param size The size of the grid's squares
     */
    public MainFrame(final GameOfLife gameOfLife, final int size) {
        super("Game of Life");

        final JPanel panel = new JPanel();
        final GridGui gridGui = new GridGui(gameOfLife, size);
        final Menu menu = new Menu(gameOfLife);

        final JButton clear = new JButton("Clear grid");
        panel.add(clear);

        this.setLocationRelativeTo(null);
        this.add(panel, BorderLayout.SOUTH);
        this.setJMenuBar(menu);
        this.add(gridGui);
        pack();

        this.setMinimumSize(new Dimension(gridGui.getWidth(),
                gridGui.getHeight() + panel.getHeight() + menu.getHeight() + 31));

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.clearGrid();
            }
        });
    }

    public static void showError(final String error) {
        final Frame errorFrame = new JFrame();
        errorFrame.setLocationRelativeTo(null);
        errorFrame.add(new Label(error));
        errorFrame.pack();
        errorFrame.setVisible(true);
    }

}
