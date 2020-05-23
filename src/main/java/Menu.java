package src.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class is used to create the menu of the application.
 */
public class Menu extends JMenuBar {

    private final GameOfLife gameOfLife;
    private final JMenu menu;

    /**
     * Constructor for the class Menu.
     * @param gameOfLife An instance of game of life
     */
    public Menu(final GameOfLife gameOfLife) {
        super();

        this.gameOfLife = gameOfLife;
        int rows = gameOfLife.getCurrentGrid().getRows();
        int cols = gameOfLife.getCurrentGrid().getColumns();

        this.menu = new JMenu("Add pattern");
        addMenuItems(rows, cols);

        this.add(menu);
    }

    /**
     * Add all buttons given the values of the Patterns enum.
     */
    private void addMenuItems(final int rows, final int cols) {
        for (final Pattern p : Pattern.values()) {
            final JMenuItem item = new JMenuItem(p.getName());
            menu.add(item);

            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    new FrameAdding(p, rows, cols, gameOfLife);
                }
            });
        }
    }

}
