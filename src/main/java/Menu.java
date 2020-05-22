package src.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
        this.menu = new JMenu("Add pattern");
        addMenuItems();

        this.add(menu);
    }

    /**
     * Add all buttons given the values of the Patterns enum.
     */
    private void addMenuItems() {
        for (final Pattern p : Pattern.values()) {
            final JMenuItem item = new JMenuItem(p.getName());
            menu.add(item);

            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {

                    gameOfLife.addPattern(p, 0, 0);

                }
            });
        }
    }

}
