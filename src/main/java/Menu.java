package src.main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {

    private final GameOfLife gameOfLife;
    private final JMenu menu;

    public Menu(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.menu = new JMenu("Add pattern");
        addButtons();

        this.add(menu);
    }

    private void addButtons() {
        for (final Pattern p : Pattern.values()) {
            JMenuItem item = new JMenuItem(p.getName());
            menu.add(item);

            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameOfLife.addPattern(p, 0, 0);
                }
            });
        }
    }
}
