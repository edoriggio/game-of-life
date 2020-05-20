package src.main.java;

import javax.swing.*;

public class Menu extends JMenuBar {

    private JMenu menu;

    public Menu() {
        menu = new JMenu("Add pattern");
        addButtons();

        this.add(menu);
    }

    private void addButtons() {
        for (Pattern p : Pattern.values()) {
            JMenuItem item = new JMenuItem(p.getName());
            menu.add(item);
        }
    }
}
